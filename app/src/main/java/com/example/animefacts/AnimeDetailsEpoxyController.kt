package com.example.animefacts

import com.airbnb.epoxy.EpoxyController
import com.example.animefacts.databinding.ModelAnimeDetailsBinding
import com.example.animefacts.network.GetAnimeByGenreResponse

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

    override fun buildModels() {
        if (isLoading) {
            return
        }

        if (animeResponse == null) {
            return
        }

        HeaderEpoxyModel(
            number = animeResponse!!.data[1].count,
            link = animeResponse!!.data[1].url,
            title = animeResponse!!.data[1].name,
        ).id("header").addTo(this)
    }
}

data class HeaderEpoxyModel(
    val number: Int,
    val link: String,
    val title: String
) : ViewBindingKotlinModel <ModelAnimeDetailsBinding>(R.layout.model_anime_details) {

    override fun ModelAnimeDetailsBinding.bind() {
        animeGenreTextView.text = title
        numberOfAnimeTitleTextView.text = number.toString()
        linkToListTitleTextView.text = link
    }

}
