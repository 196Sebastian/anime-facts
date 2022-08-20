package com.example.animefacts.epoxy

import com.airbnb.epoxy.EpoxyController
import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse

class AnimeDetailsEpoxyController : EpoxyController() {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var animeResponse: GetAnimeByGenreResponse? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    var animeImageView: GetAnimePictureByIdResponse? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        if (isLoading) {
            return
        }

        if (animeResponse == null) {
            return
        }

        AnimeDetailsEpoxyModel(
            numberOfAnimeInGenre = animeResponse!!.data[0].count,
            animeListLink = animeResponse!!.data[0].url,
            genreTitle = animeResponse!!.data[0].name,
            imageView = animeImageView!!.data[2].jpg.image_url
        ).id("header").addTo(this)

//        AnimeImageEpoxyModel(
//            imageView = animeImageView!!.data[1].jpg.image_url
//        ).id("image").addTo(this)
    }
}