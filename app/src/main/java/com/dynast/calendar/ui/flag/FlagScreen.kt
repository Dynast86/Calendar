package com.dynast.calendar.ui.flag

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun FlagScreen(
    onBackClick: () -> Unit,
    viewModel: FlagViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {

        }
    }
}

@Preview
@Composable
fun FlagScreenPreview() {
    CalendarTheme {
        FlagScreen(onBackClick = { /*TODO*/ })
    }
}