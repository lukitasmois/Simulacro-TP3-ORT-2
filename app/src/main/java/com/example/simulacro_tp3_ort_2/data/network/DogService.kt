package com.example.simulacro_tp3_ort_2.data.network

import android.util.Log
import com.example.simulacro_tp3_ort_2.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(
    private val service: DogsApiClient) {

    suspend fun getDog(): List<DogModel> {
        return withContext(Dispatchers.IO) {
            val response = try {
                service.getDog()
            } catch (e: Exception) {
                Log.e("DogService", "no hay conexion")
                null
            }

            if (response != null && response.isSuccessful) {
                val apiResponse = response.body()
                apiResponse?.images?.map { DogModel(it) } ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}