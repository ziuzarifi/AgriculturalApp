package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.adapters.AdsAdapter
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentAdsBinding
import com.example.agriculturalapp.models.advertisements.Ads
import com.example.agriculturalapp.models.advertisements.Data
import com.example.agriculturalapp.utils.OnClickAd
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsFragment : Fragment(), OnClickAd {

    lateinit var binding: FragmentAdsBinding
    private val adapter = AdsAdapter(this)
    private var id: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getInt("id") != null) {
            id = arguments!!.getInt("id")
        }
        init(id = id)
    }

    private fun init(id: Int?){
        val apiInterface = RetrofitInstance.api
        apiInterface.getAd(category_id = id)
            .enqueue(object : Callback<Ads> {
                override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                            pBar.stopNestedScroll()
                            pBar.visibility = View.GONE
                            rcView.layoutManager = GridLayoutManager(context, 1)
                            rcView.adapter = adapter
                            response.body()?.let {
                                adapter.setAd(it.data)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<Ads>, t: Throwable) {
                    binding.pBar.visibility = View.GONE
                }
            })
    }

    override fun onClickAd(ad: Data) {

    }

}