package com.example.simulacro_tp3_ort_2.data.model

import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity

data class Dog(
    val image : String?,
    val name : String?,
    val breed : String?,
    val subBreed : String?,
    val favorite : Boolean?
)


fun DogModel.toDomain() = Dog(image, name, breed, subBreed, favorite)

fun DogEntity.toDomain() = Dog(image, name, breed, subBreed, favorite)