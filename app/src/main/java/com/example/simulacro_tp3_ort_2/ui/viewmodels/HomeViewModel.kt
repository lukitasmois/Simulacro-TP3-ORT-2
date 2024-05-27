package com.example.simulacro_tp3_ort_2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simulacro_tp3_ort_2.data.model.Dog
import com.example.simulacro_tp3_ort_2.domain.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase

    ): ViewModel() {

    val dogModel = MutableLiveData<Dog>()
    val isLoading = MutableLiveData<Boolean>()
    val dogList = MutableLiveData<MutableList<Dog>>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDogsUseCase()

            if(!result.isNullOrEmpty()){
                dogModel.postValue(result[0])
                dogList.postValue(result.toMutableList())
                isLoading.postValue(false)
            }
        }
    }
}