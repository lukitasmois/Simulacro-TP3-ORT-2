package com.example.simulacro_tp3_ort_2.ui.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulacro_tp3_ort_2.R
import com.example.simulacro_tp3_ort_2.adapters.DogAdapter
import com.example.simulacro_tp3_ort_2.data.model.DogWithText
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
        val searcher = _binding?.searcher

        dogAdapter = DogAdapter(mutableListOf())

        homeViewModel.onCreate()

        _binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogAdapter
        }

        searcher?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                homeViewModel.filterDogsByName(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        homeViewModel.filteredDogList.observe(viewLifecycleOwner) { filteredList ->
            filteredList?.let {
                dogAdapter.updateList(it)
            }
        }

        homeViewModel.dogList.observe(viewLifecycleOwner) {
            it?.let {
                dogAdapter.updateList(it)
            }
        }

        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loading.isVisible = it
        }


            return binding.root
    }

}