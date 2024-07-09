package com.example.simulacro_tp3_ort_2.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simulacro_tp3_ort_2.data.model.Dog

@Entity(tableName = "dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "breed") val breed: String?,
    @ColumnInfo(name = "subBreed") val subBreed: String?,
    @ColumnInfo(name = "favorite") val favorite: Boolean?

)


fun Dog.toDataBase () = DogEntity(image = image, name = name, breed = breed, subBreed = subBreed, favorite = favorite)

