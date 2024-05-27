package com.example.simulacro_tp3_ort_2.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.adapters.DogAdapter
import com.example.simulacro_tp3_ort_2.databinding.LayFragHomeBinding
import com.example.simulacro_tp3_ort_2.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragHome : Fragment() {
    private lateinit var binding : LayFragHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var dogAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayFragHomeBinding.inflate(inflater, container, false)



        return binding.root
    }

}