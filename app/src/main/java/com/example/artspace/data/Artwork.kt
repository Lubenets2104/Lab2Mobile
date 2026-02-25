package com.example.artspace.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.artspace.R

data class Artwork(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val authorResId: Int,
    @StringRes val yearResId: Int,
    @StringRes val contentDescriptionResId: Int
)

object ArtworkDataSource {
    val artworks: List<Artwork> = listOf(
        Artwork(
            imageResId = R.drawable.artwork_mountains,
            titleResId = R.string.artwork_1_title,
            authorResId = R.string.artwork_1_author,
            yearResId = R.string.artwork_1_year,
            contentDescriptionResId = R.string.artwork_1_description
        ),
        Artwork(
            imageResId = R.drawable.artwork_sunset,
            titleResId = R.string.artwork_2_title,
            authorResId = R.string.artwork_2_author,
            yearResId = R.string.artwork_2_year,
            contentDescriptionResId = R.string.artwork_2_description
        ),
        Artwork(
            imageResId = R.drawable.artwork_night_sky,
            titleResId = R.string.artwork_3_title,
            authorResId = R.string.artwork_3_author,
            yearResId = R.string.artwork_3_year,
            contentDescriptionResId = R.string.artwork_3_description
        ),
        Artwork(
            imageResId = R.drawable.artwork_forest,
            titleResId = R.string.artwork_4_title,
            authorResId = R.string.artwork_4_author,
            yearResId = R.string.artwork_4_year,
            contentDescriptionResId = R.string.artwork_4_description
        ),
        Artwork(
            imageResId = R.drawable.artwork_ocean,
            titleResId = R.string.artwork_5_title,
            authorResId = R.string.artwork_5_author,
            yearResId = R.string.artwork_5_year,
            contentDescriptionResId = R.string.artwork_5_description
        )
    )
}
