package com.example.animefacts

import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import com.example.animefacts.network.NetworkLayer

class SharedRepository {

    suspend fun getAnimeGenre(): GetAnimeByGenreResponse? {
        val request = NetworkLayer.apiClient.getAnimeGenre()

        if (request.isSuccessful) {
            return request.body()!!
        }

        return null
    }

    suspend fun getAnimeImage(): GetAnimePictureByIdResponse? {
        val request = NetworkLayer.apiClient.getAnimePictureById()

        if (request.isSuccessful) {
            return request.body()!!
        }

        return null
    }
}