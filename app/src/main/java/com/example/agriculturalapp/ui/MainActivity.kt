package com.example.agriculturalapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.agriculturalapp.R
import com.example.agriculturalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragmentContainerView)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.categories -> navController?.navigate(R.id.categoriesFragment)

                R.id.addingAds -> navController?.navigate(R.id.addingAdsFragment)

                R.id.saved -> navController?.navigate(R.id.savedFragment)

                R.id.account -> navController?.navigate(R.id.accountFragment)
            }
            true
        }
    }

    override fun onBackPressed() {
        when(navController?.currentDestination?.id){
            R.id.categoriesFragment, R.id.addingAdsFragment, R.id.savedFragment, R.id.accountFragment -> {
                AlertDialog.Builder(this)
                    .setTitle("Вы уверены,")
                    .setMessage("что хотите выйти?")
                    .setNegativeButton("Отмена", null)
                    .setPositiveButton("Да"){ dialogInterface, i ->
                        finish()
                    }
                    .create()
                    .show()
            }
        }
        super.onBackPressed()
    }

}