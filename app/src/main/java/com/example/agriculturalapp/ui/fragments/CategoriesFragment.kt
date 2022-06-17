package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agriculturalapp.R
import com.example.agriculturalapp.adapters.CategoriesAdapter
import com.example.agriculturalapp.databinding.FragmentCategoriesBinding
import com.example.agriculturalapp.models.Category
import com.example.agriculturalapp.models.CategoryItem
import com.example.agriculturalapp.utils.OnClickCategory


class CategoriesFragment : Fragment(), OnClickCategory {

    lateinit var binding: FragmentCategoriesBinding
    private val adapter = CategoriesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onClickCategory(category: CategoryItem) {
        TODO("Not yet implemented")
    }
}