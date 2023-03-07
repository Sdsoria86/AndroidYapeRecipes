package com.example.recetasyape.data.network

import com.example.recetasyape.core.RetrofitHelper
import com.example.recetasyape.data.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class RecipeService @Inject constructor(private val api: RecipeApiClient) {

    suspend fun getRecipes(): List<RecipeModel>{
        return  withContext(Dispatchers.IO){
            val response = api.getAllRecipes()
            response.body() ?: emptyList()
        }
    }
}