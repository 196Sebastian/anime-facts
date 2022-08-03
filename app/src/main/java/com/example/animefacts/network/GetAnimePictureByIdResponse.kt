package com.example.animefacts.network

data class GetAnimePictureByIdResponse(
    val data: List<Data>
){
    data class Data(
        val jpg: Jpg,
        val webp: Webp
    )

    data class Jpg(
        val image_url: String,
        val large_image_url: String,
        val small_image_url: String
    )

    data class Webp(
        val image_url: String,
        val large_image_url: String,
        val small_image_url: String
    )
}