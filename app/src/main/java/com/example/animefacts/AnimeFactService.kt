package com.example.animefacts

import retrofit2.Call
import retrofit2.http.GET

interface AnimeFactService {

    @GET("top/anime?=1")
    fun getAnimeFactById() : Call<Any>
}