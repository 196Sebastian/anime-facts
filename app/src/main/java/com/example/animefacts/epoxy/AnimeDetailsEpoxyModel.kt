package com.example.animefacts.epoxy

import com.example.animefacts.R
import com.example.animefacts.databinding.ModelAnimeDetailsBinding
import com.example.animefacts.viewbinding.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

data class AnimeDetailsEpoxyModel(
    val numberOfAnimeInGenre: Int,
    val animeListLink: String,
    val genreTitle: String,
    val imageView: String
) : ViewBindingKotlinModel<ModelAnimeDetailsBinding>(R.layout.model_anime_details) {

    override fun ModelAnimeDetailsBinding.bind() {
        animeGenreTextView.text = genreTitle
        numberOfAnimeTitleTextView.text = numberOfAnimeInGenre.toString()
        linkToListTitleTextView.text = animeListLink

        Picasso.get().load(imageView).into(animeGenreImageView)
    }
}
