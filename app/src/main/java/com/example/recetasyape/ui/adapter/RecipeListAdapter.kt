package com.example.recetasyape.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recetasyape.R
import com.example.recetasyape.domain.model.Recipe

class RecipeListAdapter(
    private val context: Context,
    private var recipesList:MutableList<Recipe>,
    private val onClickListener:(Recipe) -> Unit
): RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(context)
        return RecipeViewHolder(itemView.inflate(R.layout.card_recipe, parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = recipesList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = recipesList.size

    fun updateRecipes(recipesList: MutableList<Recipe>){
        this.recipesList = recipesList
        notifyDataSetChanged()
    }

}