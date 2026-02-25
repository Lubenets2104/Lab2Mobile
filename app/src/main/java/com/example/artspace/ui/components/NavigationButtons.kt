package com.example.artspace.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.artspace.R

@Composable
fun NavigationButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val previousHint = stringResource(R.string.button_previous_hint)
    val nextHint = stringResource(R.string.button_next_hint)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onPreviousClick,
            enabled = isPreviousEnabled,
            modifier = Modifier
                .widthIn(min = dimensionResource(R.dimen.button_min_width))
                .semantics { contentDescription = previousHint }
        ) {
            Text(text = stringResource(R.string.button_previous))
        }
        Button(
            onClick = onNextClick,
            enabled = isNextEnabled,
            modifier = Modifier
                .widthIn(min = dimensionResource(R.dimen.button_min_width))
                .semantics { contentDescription = nextHint }
        ) {
            Text(text = stringResource(R.string.button_next))
        }
    }
}
