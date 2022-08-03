package com.example.animefacts.network

import com.example.animefacts.data.AnimeFactService
import com.example.animefacts.data.ApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val animeGenre: AnimeFactService by lazy { retrofit.create(AnimeFactService::class.java) }

    val apiClient = ApiClient(animeGenre)


}