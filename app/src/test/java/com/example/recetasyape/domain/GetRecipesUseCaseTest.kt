package com.example.recetasyape.domain

import com.example.recetasyape.data.RecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetRecipesUseCaseTest{

    @RelaxedMockK
    @MockK
    private lateinit var recipeRepository: RecipeRepository

    lateinit var getRecipesUseCase:GetRecipesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRecipesUseCase = GetRecipesUseCase(recipeRepository)
    }

    @Test
    fun whenTheApiDoesntReturnAnythingTheGetValuesFromDatabase() = runBlocking{
        //Given
        coEvery { recipeRepository.getAllRecipesFromApi() } returns emptyList()
        //When
        getRecipesUseCase()

        //Then
        coVerify(exactly = 1) { recipeRepository.getAllRecipesFromDatabase() }
    }
}