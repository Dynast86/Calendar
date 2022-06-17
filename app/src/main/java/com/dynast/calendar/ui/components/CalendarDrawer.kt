package com.dynast.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R

sealed class DrawerItems(val image: ImageVector, val title: String, val route: String) {
    object ViewAgenda : DrawerItems(Icons.Default.ViewAgenda, "일정", "ViewAgenda")
    object CalendarViewDay : DrawerItems(Icons.Default.CalendarViewDay, "일", "CalendarViewDay")
    object ViewWeek : DrawerItems(Icons.Default.ViewWeek, "3일", "ViewWeek")
    object CalendarViewWeek : DrawerItems(Icons.Default.CalendarViewWeek, "주", "CalendarViewWeek")
    object CalendarViewMonth : DrawerItems(Icons.Default.CalendarViewMonth, "월", "CalendarViewMonth")

    object Refresh : DrawerItems(Icons.Default.Refresh, "새로고침", "Refresh")
}

val items = listOf(
    DrawerItems.ViewAgenda,
    DrawerItems.CalendarViewDay,
    DrawerItems.ViewWeek,
    DrawerItems.CalendarViewWeek,
    DrawerItems.CalendarViewMonth
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarDrawer(
    modifier: Modifier = Modifier,
    selectedDestination: DrawerItems,
    onHeaderClicked: () -> Unit,
    onDrawerClicked: (DrawerItems) -> Unit
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(24.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name).uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            IconButton(onClick = onHeaderClicked) {
                Icon(imageVector = Icons.Default.MenuOpen, contentDescription = null)
            }
        }
        items.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(imageVector = item.image, contentDescription = item.title) },
                label = { Text(text = item.title, modifier = Modifier.padding(horizontal = 16.dp)) },
                selected = selectedDestination.route == item.route,
                onClick = { onDrawerClicked(item) },
                colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent)
            )
        }
        Divider(thickness = Dp.Hairline, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        NavigationDrawerItem(
            selected = false,
            icon = { Icon(imageVector = DrawerItems.Refresh.image, contentDescription = DrawerItems.Refresh.title) },
            label = { Text(text = DrawerItems.Refresh.title, modifier = Modifier.padding(horizontal = 16.dp)) },
            onClick = { onDrawerClicked(DrawerItems.Refresh) },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarDrawerPreview() {
    CalendarDrawer(
        selectedDestination = DrawerItems.CalendarViewMonth,
        onHeaderClicked = {},
        onDrawerClicked = {})
}