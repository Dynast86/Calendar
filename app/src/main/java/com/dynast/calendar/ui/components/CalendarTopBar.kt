package com.dynast.calendar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalendarTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onDrawerClick: () -> Unit
) {
    SmallTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = onDrawerClick
            ) {
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
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CalendarTopBarPreview() {
    CalendarTopBar(title = "6월", onDrawerClick = {})
}