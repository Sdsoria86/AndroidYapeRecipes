package com.example.recetasyape.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasyape.R
import com.example.recetasyape.databinding.ActivityMainBinding
import com.example.recetasyape.domain.model.Recipe
import com.example.recetasyape.ui.adapter.RecipeListAdapter
import com.example.recetasyape.ui.view.fragments.RecipeDetailFragment
import com.example.recetasyape.ui.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val recipeViewModel: RecipeViewModel by viewModels()
    private var recipesList: MutableList<Recipe> = mutableListOf()
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: RecipeListAdapter

    private val NAME_KEY = "name_key"
    private val INGREDIENT_KEY = "ingredient_key"

    private var searchOption = NAME_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipeViewModel.onCreate()

        recipeViewModel.recipeModel.observe(this) {
            recipesList = it.toMutableList()
            initRecyclerViewRecipes()
        }

        binding.apply {

            btnSync.setOnClickListener {
                recipeViewModel.onSync()
            }

            etFilter.addTextChangedListener {

                if (radioName.isChecked){
                    searchOption = NAME_KEY
                }else if (radioIngredient.isChecked){
                    searchOption = INGREDIENT_KEY
                }

                val recipeFiltered = if (searchOption == NAME_KEY) {
                    recipesList.filter { recipes -> recipes.name.lowercase().contains(it.toString().lowercase()) }
                } else{
                    if (searchOption == INGREDIENT_KEY) {
                        recipesList.filter { recipes -> recipes.description.lowercase().contains(it.toString().lowercase()) }
                    } else {
                        recipesList.filter { recipes -> recipes.description.lowercase().contains(it.toString().lowercase()) }
                    }
                }
                adapter.updateRecipes(recipeFiltered as MutableList<Recipe>)

            }
        }
    }

    private fun initRecyclerViewRecipes(){
        recycler = binding.recyclerRecipes
        recycler.layoutManager = GridLayoutManager(this, 2)
        adapter = RecipeListAdapter(this, recipesList){ recipes ->
            onItemSelected(
                recipes
            )
        }
        recycler.adapter = adapter
    }

    private fun onItemSelected(recipe: Recipe){
        supportFragmentManager.beginTransaction().replace(R.id.containerFragment, RecipeDetailFragment(recipe)).commit()
    }
}