package com.example.animefacts

import com.example.animefacts.network.GetAnimeByGenreResponse
import retrofit2.Call
import retrofit2.http.GET

interface AnimeFactService {
    @GET("genres/anime")
    fun getAnimeFactById() : Call<GetAnimeByGenreResponse>
}