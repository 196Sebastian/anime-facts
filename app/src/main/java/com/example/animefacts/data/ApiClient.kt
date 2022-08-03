package com.example.animefacts.data

import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import retrofit2.Response

class ApiClient(
    private val animeFactService: AnimeFactService
) {
    suspend fun getAnimeGenre(): Response<GetAnimeByGenreResponse> {
        return animeFactService.getAnimeGenre()
    }

    suspend fun getAnimePictureById(): Response<GetAnimePictureByIdResponse> {
        return animeFactService.getAnimePictureById()
    }
}