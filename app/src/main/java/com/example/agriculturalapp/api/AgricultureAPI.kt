package com.example.agriculturalapp.api

import com.example.agriculturalapp.models.CategoryItem
import retrofit2.Call
import retrofit2.http.GET

interface AgricultureAPI {

    @GET("advertisements/categories")
    fun getCategory(): Call<List<CategoryItem>>
}