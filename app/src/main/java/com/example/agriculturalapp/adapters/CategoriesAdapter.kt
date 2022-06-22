package com.example.agriculturalapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriculturalapp.R
import com.example.agriculturalapp.databinding.CategoryItemBinding
import com.example.agriculturalapp.models.CategoryItem
import com.example.agriculturalapp.utils.Constants
import com.example.agriculturalapp.utils.OnClickCategory

class CategoriesAdapter(
    private val onClick: OnClickCategory
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {

    private var categoryList: List<CategoryItem> = emptyList()

    class CategoriesHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = CategoryItemBinding.bind(item)

        fun bind(category: CategoryItem) = with(binding) {
            tvTitle.text = category.title
            textView.text = category.quantity.toString()
            Glide
                .with(imView)
                .load(Constants.MEDIA_URL + category.icon)
                .into(imView)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoriesAdapter.CategoriesHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return CategoriesHolder(view)
    }

    override fun onBindViewHolder(p0: CategoriesAdapter.CategoriesHolder, p1: Int) {
        val currentItem = categoryList[p1]
        p0.bind(categoryList[p1])
        p0.itemView.setOnClickListener {
            onClick.onClickCategory(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setCategory(list: List<CategoryItem>) {
        categoryList = list
    }
}