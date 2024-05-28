package com.example.simulacro_tp3_ort_2.data.model

import com.google.gson.annotations.SerializedName


data class ApiRespone(
    @SerializedName("message") val  images: List<String>
)
