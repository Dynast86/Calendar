package com.dynast.calendar.ui.components

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SnackBarHost(
    snackBarHostState: SnackbarHostState
) {
    SnackbarHost(
        snackBarHostState,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(align = Alignment.Bottom)
    )
}