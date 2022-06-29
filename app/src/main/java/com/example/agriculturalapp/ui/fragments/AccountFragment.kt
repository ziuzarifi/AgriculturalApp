package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.agriculturalapp.R
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentAccountBinding
import com.example.agriculturalapp.models.profile.user.ProfileUser
import com.example.agriculturalapp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountFragment : Fragment() {

    lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(layoutInflater)
        init()

        binding.tvInfo.setOnClickListener {
            findNavController().navigate(R.id.profileUserFragment)
        }

        binding.tvMyAds.setOnClickListener {
            findNavController().navigate(R.id.myAdsFragment)
        }



        binding.tvContactCenter.setOnClickListener {
            findNavController().navigate(R.id.contactCenterFragment)
        }

        binding.tvExit.setOnClickListener {
            AlertDialog.Builder(activity!!)
                .setTitle("Вы уверены,")
                .setMessage("что хотите выйти?")
                .setNegativeButton("Отмена", null)
                .setPositiveButton("Да"){ _, _ ->
                }
                .create()
                .show()
        }

        return binding.root

    }

    private fun init(){
        val apiInterface = RetrofitInstance.api
        apiInterface.getProfileInfo()
            .enqueue(object : Callback<ProfileUser>{
                override fun onResponse(call: Call<ProfileUser>, response: Response<ProfileUser>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                            tvName.background = null
                            tvAge.background = null
                            tvLocation.background = null
                            imView.background = null
                            tvName.text = response.body()?.data?.name ?: ""
                            tvAge.text = response.body()?.data?.date_of_birth ?: ""
                            tvLocation.text = response.body()?.data?.address ?: ""
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

}