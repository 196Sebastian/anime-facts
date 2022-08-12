package com.example.animefacts.data

import com.example.animefacts.SimpleResponse
import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import retrofit2.Response
import java.lang.Exception

class ApiClient(
    private val animeFactService: AnimeFactService
) {
    suspend fun getAnimeGenre(): SimpleResponse<GetAnimeByGenreResponse> {
        return safeApiCall { animeFactService.getAnimeGenre() }
    }

    suspend fun getAnimePictureById(animeId: Int): SimpleResponse<GetAnimePictureByIdResponse> {
        return safeApiCall { animeFactService.getAnimePictureById(animeId) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}