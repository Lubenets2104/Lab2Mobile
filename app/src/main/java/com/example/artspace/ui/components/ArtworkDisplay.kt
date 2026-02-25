package com.example.artspace.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.artspace.R

@Composable
fun ArtworkDisplay(
    imageResId: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .border(
                width = dimensionResource(R.dimen.image_border_width),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f)
            ),
        shadowElevation = dimensionResource(R.dimen.image_elevation),
        color = MaterialTheme.colorScheme.surface
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .sizeIn(maxHeight = 400.dp)
                .padding(dimensionResource(R.dimen.image_padding))
        )
    }
}
