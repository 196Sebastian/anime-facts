package com.example.animefacts.data

import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AnimeFactService {
    @GET("genres/anime")
    suspend fun getAnimeGenre() : Response<GetAnimeByGenreResponse>

    @GET("anime/16498/pictures")
    suspend fun getAnimePictureById(): Response<GetAnimePictureByIdResponse>
}