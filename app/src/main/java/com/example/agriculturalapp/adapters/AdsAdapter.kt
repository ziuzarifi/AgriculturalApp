package com.example.agriculturalapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriculturalapp.R
import com.example.agriculturalapp.databinding.AdItemBinding
import com.example.agriculturalapp.models.advertisements.Data
import com.example.agriculturalapp.utils.Constants
import com.example.agriculturalapp.utils.OnClickAd

class AdsAdapter(
    private val onClick: OnClickAd
): RecyclerView.Adapter<AdsAdapter.AdsHolder>() {

    private var adsList: List<Data> = emptyList()

    class AdsHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = AdItemBinding.bind(item)

        fun bind(ad: Data) = with(binding) {
            tvTitle.text = ad.title
            tvPrice.text = ad.price
            Glide
                .with(imView)
                .load(Constants.MEDIA_URL + ad.images)
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

    fun setAd(list: List<Data>) {
        adsList = list
    }
}