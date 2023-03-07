package com.example.recetasyape.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recetasyape.data.database.dao.RecipesDao
import com.example.recetasyape.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDatabase:RoomDatabase() {

    abstract fun getRecipeDao():RecipesDao
}