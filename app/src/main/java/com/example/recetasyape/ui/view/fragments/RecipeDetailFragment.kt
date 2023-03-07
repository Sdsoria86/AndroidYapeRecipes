package com.example.recetasyape.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.recetasyape.databinding.FragmentRecipeDetailBinding
import com.example.recetasyape.domain.model.Recipe
import com.example.recetasyape.ui.view.MapActivity
import javax.inject.Inject


class RecipeDetailFragment @Inject constructor(private val recipe: Recipe) : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get( ) = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        binding.apply {
            tvName.text = recipe.name
            tvDescription.text = recipe.description
            Glide.with(ivImage.context).load(recipe.image).into(ivImage)

            btnClose.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().remove(this@RecipeDetailFragment).commit()
            }
            btnMap.setOnClickListener {
                val intent = Intent(activity, MapActivity::class.java)
                intent.putExtra("lat", recipe.lat)
                intent.putExtra("lon", recipe.lon)
                intent.putExtra("name", recipe.name)
                startActivity(intent)
            }
        }

        return binding.root
    }
}