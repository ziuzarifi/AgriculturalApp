package com.example.agriculturalapp.api

import com.example.agriculturalapp.models.advertisements.Ads
import com.example.agriculturalapp.models.advertisements.CategoryItem
import com.example.agriculturalapp.models.profile.contact_center.ContactCenter
import com.example.agriculturalapp.models.profile.contact_center.Data
import com.example.agriculturalapp.models.profile.user.ProfileUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AgricultureAPI {

    @GET("advertisements/categories")
    fun getCategory(): Call<List<CategoryItem>>

    @GET("profile/advertisements")
    fun getMyAds(): Call<Ads>

    @GET("profile/show")
    fun getProfileInfo(): Call<ProfileUser>

    @GET("advertisements/")
    fun getAd(
        @Query("category_id") category_id: Int? = null
    ): Call<Ads>

    @GET("profile/favorites")
    fun getFavorites(): Call<Ads>

    @POST("profile/update?_method=PUT")
    fun updateProfileInfo(): Call<ProfileUser>

    @GET("profile/center")
    fun getContactInfo(): Call<ContactCenter>
}