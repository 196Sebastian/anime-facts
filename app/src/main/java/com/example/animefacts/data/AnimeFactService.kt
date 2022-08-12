package com.example.animefacts.data

import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeFactService {
    @GET("genres/anime")
    suspend fun getAnimeGenre() : Response<GetAnimeByGenreResponse>

    @GET("anime/{anime-id}/pictures")
    suspend fun getAnimePictureById(
        @Path("anime-id") animeId: Int
    ): Response<GetAnimePictureByIdResponse>
}