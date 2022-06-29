package com.example.agriculturalapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agriculturalapp.databinding.FragmentDetailsAdBinding

class DetailsAdFragment : Fragment() {

    lateinit var binding: FragmentDetailsAdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsAdBinding.inflate(layoutInflater)

        return binding.root
    }



}