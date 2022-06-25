package com.example.agriculturalapp.api

import com.example.agriculturalapp.models.advertisements.Ads
import com.example.agriculturalapp.models.advertisements.CategoryItem
import com.example.agriculturalapp.models.advertisements.Data
import com.example.agriculturalapp.models.profile.ProfileUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface AgricultureAPI {

    @GET("advertisements/categories")
    fun getCategory(): Call<List<CategoryItem>>

    @GET("profile/show")
    fun getProfileInfo(): Call<ProfileUser>

    @GET("advertisements/?category_id=1")
    fun getAd(): Call<Ads>

    @POST("profile/update?_method=PUT")
    fun updateProfileInfo(): Call<ProfileUser>
}