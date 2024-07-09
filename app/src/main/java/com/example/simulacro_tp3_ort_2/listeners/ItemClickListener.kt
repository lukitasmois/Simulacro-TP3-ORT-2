package com.example.simulacro_tp3_ort_2.listeners

import com.example.simulacro_tp3_ort_2.domain.model.DogWithText

interface ItemClickListener {
    fun saveDog(dog : DogWithText)
}