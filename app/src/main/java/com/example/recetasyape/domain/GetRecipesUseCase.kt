package com.example.recetasyape.domain

import com.example.recetasyape.data.RecipeRepository
import com.example.recetasyape.data.database.entities.toDatabase
import com.example.recetasyape.domain.model.Recipe
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val repository: RecipeRepository) {

    suspend operator fun invoke():List<Recipe>{

        var recipes = repository.getAllRecipesFromDatabase()

        return recipes.ifEmpty {
            recipes = repository.getAllRecipesFromApi()
            if (recipes.isNotEmpty()) {
                repository.clearRecipes()
                repository.insertRecipes(recipes.map { it.toDatabase() })
                recipes
            } else {
                repository.getAllRecipesFromDatabase()
            }
        }
    }

}