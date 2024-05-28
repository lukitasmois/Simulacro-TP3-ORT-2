package com.example.simulacro_tp3_ort_2.data.network

import com.example.simulacro_tp3_ort_2.data.model.ApiRespone
import retrofit2.Response
import retrofit2.http.GET

interface DogsApiClient {

    @GET("api/breeds/image/random/2")
    suspend fun getDog() : Response<ApiRespone>
}