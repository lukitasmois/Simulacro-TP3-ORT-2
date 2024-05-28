package com.example.simulacro_tp3_ort_2.data

import com.example.simulacro_tp3_ort_2.data.database.dao.DogDao
import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity
import com.example.simulacro_tp3_ort_2.data.model.Dog
import com.example.simulacro_tp3_ort_2.data.model.DogModel
import com.example.simulacro_tp3_ort_2.data.model.toDomain
import com.example.simulacro_tp3_ort_2.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val remote: DogService,
    private val dogDao : DogDao
){

    suspend fun getAllDogsFromApi(): List<Dog>{
        val response : List<DogModel> = remote.getDog()
        return response.map { it.toDomain() }
    }

    suspend fun getAllDogsFromDatabase(): List<Dog>{
        val response: List<DogEntity> = dogDao.getAllDogs()
        return response.map { it.toDomain() }
    }

    suspend fun insertDogs(dogs:List<DogEntity>){
        dogDao.insertAll(dogs)
    }

    suspend fun clearDogs(){
        dogDao.deleteAllDogs()
    }
}