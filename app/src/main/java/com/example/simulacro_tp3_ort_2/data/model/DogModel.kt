package com.example.simulacro_tp3_ort_2.data.model

import com.google.gson.annotations.SerializedName

data class DogModel(
   @SerializedName("message") val image : String,
   val name : String? = null,
   val breed : String? = null,
   val subBreed : String? = null,
   val favorite : Boolean? = false
)