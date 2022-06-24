package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentProfileUserBinding
import com.example.agriculturalapp.models.profile.ProfileUser
import com.example.agriculturalapp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileUserFragment : Fragment() {

    lateinit var binding: FragmentProfileUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileUserBinding.inflate(layoutInflater)
        get()
        /*binding.btnSave.setOnClickListener {
            post()
            findNavController().navigate(R.id.accountFragment)
        }*/
        return binding.root
    }

    private fun get(){
        val apiInterface = RetrofitInstance.api
        apiInterface.getProfileInfo()
            .enqueue(object : Callback<ProfileUser> {
                override fun onResponse(call: Call<ProfileUser>, response: Response<ProfileUser>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                            imView.background = null
                            etFirstName.setText(response.body()?.data?.name ?: "")
                            etSecondName.setText(response.body()?.data?.surname ?: "")
                            etPhone.setText(response.body()?.data?.phone ?: "")
                            etDate.setText(response.body()?.data?.date_of_birth ?: "")
                            etLocation.setText(response.body()?.data?.address ?: "")
                            Glide
                                .with(imView)
                                .load(Constants.MEDIA_URL + response.body()?.data?.image)
                                .circleCrop()
                                .into(imView)
                        }
                    }
                }

                override fun onFailure(call: Call<ProfileUser>, t: Throwable) {

                }

            })
    }


    /*private fun post(){
        val apiInterface = RetrofitInstance.api
        apiInterface.updateProfileInfo()
            .enqueue(object : Callback<ProfileUser> {
                override fun onResponse(call: Call<ProfileUser>, response: Response<ProfileUser>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                        }
                    }
                }

                override fun onFailure(call: Call<ProfileUser>, t: Throwable) {

                }

            })
    }*/

}