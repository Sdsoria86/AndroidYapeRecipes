package com.example.recetasyape.domain

import android.util.Log
import com.example.recetasyape.data.RecipeRepository
import com.example.recetasyape.data.database.entities.toDatabase
import com.example.recetasyape.domain.model.Recipe
import javax.inject.Inject

class GetRecipeSyncUseCase @Inject constructor(private val repository: RecipeRepository) {

    suspend operator fun invoke():List<Recipe>{

            var recipes = repository.getAllRecipesFromApi()
            return if (recipes.isNotEmpty()){
                repository.clearRecipes()
                repository.insertRecipes(recipes.map { it.toDatabase() })
                Log.d("RECETAS", "Desde Network")
                recipes
            }else{
                repository.getAllRecipesFromDatabase()
            }
    }
}