package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.adapters.ContactCenterAdapter
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentContactCenterBinding
import com.example.agriculturalapp.models.profile.contact_center.ContactCenter
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
        binding.imBack.setOnClickListener { activity?.onBackPressed() }
        init()
        return binding.root
    }

    private fun init(){
        val apiInterface = RetrofitInstance.api

        apiInterface.getContactInfo()
            .enqueue(object : Callback<ContactCenter> {
                override fun onResponse(call: Call<ContactCenter>, response: Response<ContactCenter>) {
                    if (response.isSuccessful){
                        binding.apply {
                            pBar.stopNestedScroll()
                            pBar.visibility = View.GONE
                            rcView.layoutManager = GridLayoutManager(context, 1)
                            rcView.adapter = adapter
                            response.body()?.let {
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