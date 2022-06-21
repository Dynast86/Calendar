package com.dynast.calendar.ui.flag

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.R
import com.dynast.calendar.extension.Animated
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun FlagScreen(
    onBackClick: () -> Unit,
    viewModel: FlagViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val titleState by remember { derivedStateOf { listState.firstVisibleItemIndex > 0 } }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    AnimatedVisibility(visible = titleState, enter = Animated.slideEnter(), exit = Animated.slideExit()) {
                        Text(
                            text = stringResource(id = R.string.flag),
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            FlagContent(state = listState)
        }
    }
}

@Preview
@Composable
fun FlagScreenPreview() {
    CalendarTheme {
        FlagScreen(onBackClick = { })
    }
}