package com.example.simulacro_tp3_ort_2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simulacro_tp3_ort_2.data.database.dao.DogDao
import com.example.simulacro_tp3_ort_2.data.database.entities.DogEntity

@Database(entities = [DogEntity::class], version = 0)
abstract class DogDatabase : RoomDatabase(){
    abstract fun getDogDao(): DogDao
}