package com.dynast.calendar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.ui.theme.CalendarTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun CalendarTopBar(
    title: String,
    onDrawerClick: CoroutineScope.() -> Unit
) {
    val scope = rememberCoroutineScope()

    SmallTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { scope.onDrawerClick() }) {
                Icon(Icons.Default.Menu, contentDescription = "More")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Today, contentDescription = "Today")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CalendarTopBarPreview() {
    CalendarTheme {
        CalendarTopBar(title = "6월", onDrawerClick = {})
    }
}