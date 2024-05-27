package com.example.simulacro_tp3_ort_2.ui.views.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.databinding.LayActivityWelcomeBinding
import com.example.simulacro_tp3_ort_2.ui.viewmodel.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityWelcome : AppCompatActivity() {
    lateinit var binding: LayActivityWelcomeBinding
    private val welcomeViewModel: WelcomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layWelcomeButton.setOnClickListener { welcomeViewModel.buttonClick() }



    }
}