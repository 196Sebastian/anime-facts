package com.example.animefacts.network

data class GetAnimeByGenreResponse(
    val data: List<Data>
) {
    data class Data(
        val count: Int,
        val mal_id: Int,
        val name: String,
        val url: String
    )
}