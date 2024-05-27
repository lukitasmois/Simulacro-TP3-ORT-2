package com.example.simulacro_tp3_ort_2.ui.views.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.databinding.LayActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityHome : AppCompatActivity() {
    lateinit var binding: LayActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = LayActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationView = binding.layActivityHomeNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.lay_activity_home_containerView) as NavHostFragment

        setupDrawerLayout(navHostFragment, navigationView)

    }

    private fun setupDrawerLayout(navHostFragment: NavHostFragment, navigationView: NavigationView) {
        val navController = navHostFragment.navController

        navigationView.setupWithNavController(navController)
    }
}