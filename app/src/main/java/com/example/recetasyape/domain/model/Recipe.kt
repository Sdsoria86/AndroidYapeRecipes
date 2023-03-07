package com.example.recetasyape.domain.model

import com.example.recetasyape.data.database.entities.RecipeEntity
import com.example.recetasyape.data.model.RecipeModel

class Recipe(val name:String, val image:String, val description:String, val lat:String, val lon:String)

fun RecipeModel.toDomain() = Recipe(name, image, description, lat, lon)
fun RecipeEntity.toDomain() = Recipe(name, image, description, lat, lon)