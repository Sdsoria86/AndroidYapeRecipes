package com.example.recetasyape.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recetasyape.domain.GetRecipeSyncUseCase
import com.example.recetasyape.domain.GetRecipesUseCase
import com.example.recetasyape.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val getRecipesUseCase:GetRecipesUseCase,
    private val getRecipeSyncUseCase: GetRecipeSyncUseCase
) : ViewModel() {

    var recipeModel = MutableLiveData<List<Recipe>>()

    init {
        recipeModel = MutableLiveData()
    }

    fun onCreate(){
        viewModelScope.launch {
            val result = getRecipesUseCase()
            if (result.isNotEmpty()){
                recipeModel.postValue(result)
            }
        }
    }

    fun onSync(){
        viewModelScope.launch {
            val result = getRecipeSyncUseCase()
            if (result.isNotEmpty()){
                recipeModel.postValue(result)
            }
        }
    }
}