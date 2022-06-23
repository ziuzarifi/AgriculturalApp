package com.example.agriculturalapp.api

import com.example.agriculturalapp.models.CategoryItem
import com.example.agriculturalapp.models.ProfileUser
import retrofit2.Call
import retrofit2.http.GET

interface AgricultureAPI {

    @GET("advertisements/categories")
    fun getCategory(): Call<List<CategoryItem>>

    @GET("profile/show")
    fun getProfileInfo(): Call<ProfileUser>
}