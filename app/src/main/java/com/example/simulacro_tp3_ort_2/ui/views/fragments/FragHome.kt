package com.example.simulacro_tp3_ort_2.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.adapters.DogAdapter
import com.example.simulacro_tp3_ort_2.databinding.LayFragHomeBinding
import com.example.simulacro_tp3_ort_2.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragHome : Fragment() {
    private var _binding:LayFragHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel : HomeViewModel by viewModels()
    private lateinit var dogAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragHomeBinding.inflate(inflater, container, false)

        dogAdapter = DogAdapter(mutableListOf())

        homeViewModel.onCreate()

        _binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogAdapter
        }

        homeViewModel.dogList.observe(viewLifecycleOwner) {
            it?.let {
                dogAdapter.updateList(it)
            }
        }

        return binding.root
    }

}