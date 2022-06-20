package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agriculturalapp.databinding.FragmentAddingAdsBinding

class AddingAdsFragment : Fragment() {

    lateinit var binding: FragmentAddingAdsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddingAdsBinding.inflate(layoutInflater)
        return binding.root
    }


}