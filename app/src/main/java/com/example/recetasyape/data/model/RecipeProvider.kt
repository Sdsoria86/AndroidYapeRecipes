package com.example.recetasyape.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeProvider @Inject constructor() {
    var recipes:List<RecipeModel> = emptyList()
}