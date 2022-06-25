package com.example.agriculturalapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriculturalapp.R
import com.example.agriculturalapp.databinding.AdItemBinding
import com.example.agriculturalapp.databinding.CategoryItemBinding
import com.example.agriculturalapp.models.advertisements.Ads
import com.example.agriculturalapp.models.advertisements.CategoryItem
import com.example.agriculturalapp.models.advertisements.Data
import com.example.agriculturalapp.utils.Constants
import com.example.agriculturalapp.utils.OnClickAd

class AdsAdapter(
    private val onClick: OnClickAd
): RecyclerView.Adapter<AdsAdapter.AdsHolder>() {

    private lateinit var adsList: Ads = emptyArray()

    class AdsHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = AdItemBinding.bind(item)

        fun bind(ad: Ads) = with(binding) {
            tvTitle.text = ad.data.title
            tvPrice.text = ad.data.price
            Glide
                .with(imView)
                .load(Constants.MEDIA_URL + ad.data.images)
                .into(imView)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdsHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.ad_item, p0, false)
        return AdsHolder(view)
    }

    override fun onBindViewHolder(p0: AdsHolder, p1: Int) {
        val currentItem = adsList[p1]
        p0.bind(adsList[p1])
        p0.itemView.setOnClickListener {
            onClick.onClickAd(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return adsList.size
    }

    fun setAd(list: Ads) {
        adsList = list
    }
}