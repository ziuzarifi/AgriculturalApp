package com.example.agriculturalapp.models.advertisements

data class Data(
    val address: String,
    val category: CategoryX,
    val created_at: String,
    val description: String,
    val email: String,
    val id: Int,
    val images: String,
    val is_favorite: Boolean,
    val moderation_status: ModerationStatus,
    val phone: String,
    val price: String,
    val title: String,
    val user: User
)