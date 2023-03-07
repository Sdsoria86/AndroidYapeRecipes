package com.example.recetasyape.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recetasyape.data.database.entities.RecipeEntity

@Dao
interface RecipesDao {

    @Query("SELECT * FROM recipes_table")
    suspend fun getAllRecipes(): List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recipes:List<RecipeEntity>)

    @Query("DELETE FROM recipes_table")
    suspend fun deleteAllRecipes()

    @Query("SELECT * FROM recipes_table WHERE name = :name")
    suspend fun getRecipe(name: String): RecipeEntity
}