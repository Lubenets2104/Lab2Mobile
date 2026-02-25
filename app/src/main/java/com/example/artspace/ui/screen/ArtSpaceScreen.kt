package com.example.artspace.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.artspace.R
import com.example.artspace.data.ArtworkDataSource
import com.example.artspace.ui.components.ArtworkDescription
import com.example.artspace.ui.components.ArtworkDisplay
import com.example.artspace.ui.components.NavigationButtons

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }

    val artworks = ArtworkDataSource.artworks
    val currentArtwork = artworks[currentIndex]
    val isFirstArtwork = currentIndex == 0
    val isLastArtwork = currentIndex == artworks.lastIndex

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        LandscapeLayout(
            imageResId = currentArtwork.imageResId,
            contentDescription = stringResource(currentArtwork.contentDescriptionResId),
            titleResId = currentArtwork.titleResId,
            authorResId = currentArtwork.authorResId,
            yearResId = currentArtwork.yearResId,
            isPreviousEnabled = !isFirstArtwork,
            isNextEnabled = !isLastArtwork,
            onPreviousClick = { currentIndex-- },
            onNextClick = { currentIndex++ },
            modifier = modifier
        )
    } else {
        PortraitLayout(
            imageResId = currentArtwork.imageResId,
            contentDescription = stringResource(currentArtwork.contentDescriptionResId),
            titleResId = currentArtwork.titleResId,
            authorResId = currentArtwork.authorResId,
            yearResId = currentArtwork.yearResId,
            isPreviousEnabled = !isFirstArtwork,
            isNextEnabled = !isLastArtwork,
            onPreviousClick = { currentIndex-- },
            onNextClick = { currentIndex++ },
            modifier = modifier
        )
    }
}

@Composable
private fun PortraitLayout(
    imageResId: Int,
    contentDescription: String,
    titleResId: Int,
    authorResId: Int,
    yearResId: Int,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        ArtworkDisplay(
            imageResId = imageResId,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.section_spacing)))

        ArtworkDescription(
            titleResId = titleResId,
            authorResId = authorResId,
            yearResId = yearResId
        )

        Spacer(modifier = Modifier.weight(1f))

        NavigationButtons(
            onPreviousClick = onPreviousClick,
            onNextClick = onNextClick,
            isPreviousEnabled = isPreviousEnabled,
            isNextEnabled = isNextEnabled
        )
    }
}

@Composable
private fun LandscapeLayout(
    imageResId: Int,
    contentDescription: String,
    titleResId: Int,
    authorResId: Int,
    yearResId: Int,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.screen_padding)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ArtworkDisplay(
            imageResId = imageResId,
            contentDescription = contentDescription,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.section_spacing)))

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtworkDescription(
                titleResId = titleResId,
                authorResId = authorResId,
                yearResId = yearResId
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.section_spacing)))

            NavigationButtons(
                onPreviousClick = onPreviousClick,
                onNextClick = onNextClick,
                isPreviousEnabled = isPreviousEnabled,
                isNextEnabled = isNextEnabled
            )
        }
    }
}
