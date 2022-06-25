package com.example.agriculturalapp.utils

import com.example.agriculturalapp.models.advertisements.Ads
import com.example.agriculturalapp.models.advertisements.Data

interface OnClickAd {
    fun onClickAd(ad: Ads)
}