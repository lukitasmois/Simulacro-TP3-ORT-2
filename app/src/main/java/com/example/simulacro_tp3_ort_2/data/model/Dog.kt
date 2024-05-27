package com.example.simulacro_tp3_ort_2.data.model

import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity

data class Dog(
    val image : String
)


fun DogModel.toDomain() = Dog(image)

fun DogEntity.toDomain() = Dog(image)