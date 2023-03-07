package com.example.recetasyape.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetasyape.databinding.CardRecipeBinding
import com.example.recetasyape.domain.model.Recipe

class RecipeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = CardRecipeBinding.bind(view)

    fun render(recipe: Recipe, onClickListener:(Recipe) -> Unit){
        binding.apply {
            txtNameRecipe.text = recipe.name
            Glide.with(ivImageRecipe.context).load(recipe.image).into(ivImageRecipe)

            linearItemRecipe.setOnClickListener { onClickListener(recipe) }
        }

    }
}