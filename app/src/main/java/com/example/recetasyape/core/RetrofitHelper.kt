package com.example.recetasyape.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo3642495.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}