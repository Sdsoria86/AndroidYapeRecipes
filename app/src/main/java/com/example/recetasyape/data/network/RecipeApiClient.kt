package com.example.recetasyape.data.network

import com.example.recetasyape.data.model.RecipeModel
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApiClient {
    @GET("recetas")
    suspend fun getAllRecipes(): Response<List<RecipeModel>>

}