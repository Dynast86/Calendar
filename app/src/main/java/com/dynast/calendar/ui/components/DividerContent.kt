package com.dynast.calendar.ui.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val paddingStart = 54.dp

@Composable
fun DividerContent(
    modifier: Modifier = Modifier,
    padding: Boolean = false
) {
    Divider(
        modifier = modifier, thickness = Dp.Hairline,
        color = MaterialTheme.colorScheme.surfaceTint,
        startIndent = if (padding) paddingStart else 0.dp
    )
}