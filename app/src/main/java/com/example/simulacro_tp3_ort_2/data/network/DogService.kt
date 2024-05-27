package com.example.simulacro_tp3_ort_2.data.network

import com.example.simulacro_tp3_ort_2.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(
    private val service: DogsApiClient
) {

    suspend fun getDog(): List<DogModel> {
        return try {
            val response = withContext(Dispatchers.IO) {
                service.getDogs()
            }

            if (response.isSuccessful) {
                response.body()?.dogs ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}