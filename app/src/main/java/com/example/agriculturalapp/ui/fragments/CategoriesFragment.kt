package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.adapters.CategoriesAdapter
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentCategoriesBinding
import com.example.agriculturalapp.models.CategoryItem
import com.example.agriculturalapp.utils.OnClickCategory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoriesFragment : Fragment(), OnClickCategory {

    lateinit var binding: FragmentCategoriesBinding
    private val adapter = CategoriesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){
        val apiInterface = RetrofitInstance.api

        apiInterface.getCategory()
            .enqueue(object : Callback<List<CategoryItem>>{
                override fun onResponse(call: Call<List<CategoryItem>>, response: Response<List<CategoryItem>>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                            pBar.stopNestedScroll()
                            pBar.visibility = View.GONE
                            rcView.layoutManager = GridLayoutManager(context, 1)
                            rcView.adapter = adapter
                            response.body()?.let {
                                adapter.setCategory(it)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<CategoryItem>>, t: Throwable) {
                    binding.pBar.visibility = View.GONE
                }
            })
    }

    override fun onClickCategory(category: CategoryItem) {

    }
}