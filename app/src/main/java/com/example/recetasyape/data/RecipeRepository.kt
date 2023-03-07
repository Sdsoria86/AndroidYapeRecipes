package com.example.recetasyape.data

import com.example.recetasyape.data.database.dao.RecipesDao
import com.example.recetasyape.data.database.entities.RecipeEntity
import com.example.recetasyape.data.model.RecipeModel
import com.example.recetasyape.data.model.RecipeProvider
import com.example.recetasyape.data.network.RecipeService
import com.example.recetasyape.domain.model.Recipe
import com.example.recetasyape.domain.model.toDomain
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeService,
    private val recipeDao: RecipesDao
){

    suspend fun getAllRecipesFromApi():List<Recipe>{
        val response = api.getRecipes()
        return  response.map { it.toDomain() }
    }

    suspend fun getAllRecipesFromDatabase():List<Recipe>{
        val response = recipeDao.getAllRecipes()
        return  response.map { it.toDomain() }
    }

    suspend fun insertRecipes(recipes:List<RecipeEntity>){
        recipeDao.insertAll(recipes)
    }

    suspend fun getRecipeDB(name:String): Recipe{
        val response = recipeDao.getRecipe(name)
        return response.toDomain()
    }

    suspend fun clearRecipes(){
        recipeDao.deleteAllRecipes()
    }
}