package com.example.animefacts

import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import com.example.animefacts.network.NetworkLayer

class SharedRepository {

    suspend fun getAnimeGenre(): GetAnimeByGenreResponse? {
        val request = NetworkLayer.apiClient.getAnimeGenre()

        if (request.failed) {
            return null
        }

        if (!request.isSuccessful) {
            return null
        }

        return request.body
    }

    suspend fun getAnimeImage(animeId: Int): GetAnimePictureByIdResponse? {
        val request = NetworkLayer.apiClient.getAnimePictureById(animeId)

        if (request.failed) {
            return null
        }

        if (!request.isSuccessful) {
            return null
        }

        return request.body
    }
}