package com.example.agriculturalapp.ui.fragments

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.api.RetrofitInstance
import com.example.agriculturalapp.databinding.FragmentAddingAdsBinding
import com.example.agriculturalapp.models.CategoryItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddingAdsFragment : Fragment(){

    private lateinit var binding: FragmentAddingAdsBinding
//    private val spinner: Spinner = binding.spinner
    var categories = MutableLiveData<List<String>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddingAdsBinding.inflate(layoutInflater)
        init()

        categories.observe(viewLifecycleOwner) {
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, it)

            binding.spinner.adapter = arrayAdapter
            binding.spinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }

        return binding.root
    }

    private fun init(){
        val apiInterface = RetrofitInstance.api

        apiInterface.getCategory()
            .enqueue(object : Callback<List<CategoryItem>> {
                override fun onResponse(call: Call<List<CategoryItem>>, response: Response<List<CategoryItem>>) {
                    if (response.isSuccessful){
                        Log.d("TAG", "onResponse: ${response.body().toString()}")
                        binding.apply {
                            categories.value = response.body()?.map { it.title } ?: emptyList()
                            }
                        }
                    }
                override fun onFailure(call: Call<List<CategoryItem>>, t: Throwable) {

                }
            })
    }

}