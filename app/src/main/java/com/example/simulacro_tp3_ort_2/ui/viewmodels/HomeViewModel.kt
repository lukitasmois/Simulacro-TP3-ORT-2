package com.example.simulacro_tp3_ort_2.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simulacro_tp3_ort_2.data.database.entities.DogImpl
import com.example.simulacro_tp3_ort_2.data.model.Dog
import com.example.simulacro_tp3_ort_2.data.model.DogWithText
import com.example.simulacro_tp3_ort_2.domain.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val dogList = MutableLiveData<MutableList<DogWithText>>()
    val filteredDogList = MutableLiveData<MutableList<DogWithText>>()

    private val dogWithTextList = listOf(
        DogWithText("Perro1", null, null, null),
        DogWithText("Perro2", null, null, null),
        DogWithText("Perro3", null, null, null),
        DogWithText("Perro4", null, null, null)
    )

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDogsUseCase()

            if (!result.isNullOrEmpty()) {
                val combinedList = result.map { dog ->
                    val randomDogWithText = dogWithTextList.random()
                    val breed = DogImpl.getBreed(dog.image)
                    val subBreed = DogImpl.getSubBreed(dog.image)
                    randomDogWithText.copy(image = dog.image, breed = breed, subBreed = subBreed)
                }.toMutableList()

                dogList.postValue(combinedList)
            }
            isLoading.postValue(false)
        }
    }

    fun filterDogsByName(dogName: String) {
        val filteredList = dogList.value?.filter { it.name.contains(dogName, ignoreCase = true) }
        filteredDogList.postValue(filteredList?.toMutableList())
    }

}
