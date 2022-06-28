package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.R
import com.example.agriculturalapp.adapters.CategoriesAdapter
import com.example.agriculturalapp.adapters.ContactCenterAdapter
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentContactCenterBinding
import com.example.agriculturalapp.models.advertisements.CategoryItem
import com.example.agriculturalapp.models.profile.contact_center.ContactCenter
import com.example.agriculturalapp.models.profile.contact_center.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactCenterFragment : Fragment() {

    lateinit var binding: FragmentContactCenterBinding
    private val adapter = ContactCenterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactCenterBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){
        val apiInterface = RetrofitInstance.api

        apiInterface.getContactInfo()
            .enqueue(object : Callback<ContactCenter> {
                override fun onResponse(call: Call<ContactCenter>, response: Response<ContactCenter>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body()}")

                        binding.apply {
                            pBar.stopNestedScroll()
                            pBar.visibility = View.GONE
                            rcView.layoutManager = GridLayoutManager(context, 1)
                            rcView.adapter = adapter
                            response.body()?.let {
                                Log.e("Contacts", "list: $it", )
                                adapter.setContactInfo(it.data)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ContactCenter>, t: Throwable) {
                    binding.pBar.visibility = View.GONE
                }
            })
    }

}