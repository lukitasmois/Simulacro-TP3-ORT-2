package com.example.simulacro_tp3_ort_2.domain

import com.example.simulacro_tp3_ort_2.data.DogRepository
import com.example.simulacro_tp3_ort_2.data.database.entities.toDataBase
import com.example.simulacro_tp3_ort_2.data.model.Dog
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(
    private val repository: DogRepository
){
    suspend operator fun invoke(): List<Dog>{
        val dogs = repository.getAllDogsFromApi()

        return if(dogs.isNotEmpty()){
            //Elimino los registros para hacer una nueva inserción
            repository.clearDogs()


            repository.insertDogs(dogs.map { it.toDataBase() })
            dogs
        }else{
            repository.getAllDogsFromDatabase()
        }
    }
}