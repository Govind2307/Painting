package com.example.painting

import com.example.painting.datafiles.DataItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val api: UnsplashApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create( UnsplashApi::class.java )
    }
}