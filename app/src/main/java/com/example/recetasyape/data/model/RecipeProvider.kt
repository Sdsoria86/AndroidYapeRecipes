package com.example.recetasyape.data.model

import com.example.recetasyape.data.network.RecipeService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeProvider @Inject constructor() {
    var recipes:List<RecipeModel> = emptyList()
}