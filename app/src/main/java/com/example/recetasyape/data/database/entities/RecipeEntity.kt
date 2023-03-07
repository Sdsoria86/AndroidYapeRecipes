package com.example.recetasyape.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recetasyape.domain.model.Recipe

@Entity(tableName = "recipes_table")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "image") val image:String,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "lat") val lat:String,
    @ColumnInfo(name = "lon") val lon:String
)

fun Recipe.toDatabase() = RecipeEntity(name = name, image =  image, description =  description, lat =  lat, lon =  lon)