package com.example.simulacro_tp3_ort_2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simulacro_tp3_ort_2.data.database.dao.DogDao
import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity
import com.example.simulacro_tp3_ort_2.data.database.entities.DogImpl
import com.example.simulacro_tp3_ort_2.data.model.Dog
import com.example.simulacro_tp3_ort_2.domain.model.DogWithText
import com.example.simulacro_tp3_ort_2.domain.GetDogsUseCase
import com.example.simulacro_tp3_ort_2.listeners.ItemClickListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase,
    private val dogDao: DogDao
) : ViewModel(), ItemClickListener {

    val isLoading = MutableLiveData<Boolean>()
    val dogList = MutableLiveData<MutableList<DogWithText>?>()
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
                    saveDogInDB(dog)
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

    override fun saveDog(dog: DogWithText) {
        //se cambia el estado de guardado del perro
        if(dog.favorite == true) {
            dog.favorite = false
        }else {
            dog.favorite = true
        }

        //se obtiene la lista actual de perros
        val currentList = dogList.value
        //se obtiene el indice del perro en la lista
        val index = currentList?.indexOf(dog)

        //se verifica que el perro no sea nulo
        if (index != null && index != -1) {
            //se actualiza el perro en la lista con el nuevo estado
            //se actualiza la lista
            currentList[index] = dog
            dogList.postValue(currentList)
        }

    }

    private fun saveDogInDB(dog: Dog){
        viewModelScope.launch {
            dogDao.insertDog(DogEntity(image = dog.image, name = dog.name, breed = dog.breed, subBreed = dog.subBreed, favorite = false))
        }
    }

}
