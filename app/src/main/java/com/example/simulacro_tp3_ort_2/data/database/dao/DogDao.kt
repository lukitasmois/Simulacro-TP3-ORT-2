package com.example.simulacro_tp3_ort_2.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity

@Dao
interface DogDao {

    @Query("SELECT * FROM dog_table ORDER BY image DESC")
    suspend fun getAllDogs(): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogs:List<DogEntity>)

    @Query("DELETE FROM dog_table")
    suspend fun deleteAllDogs()
}