package com.dynast.calendar.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.objects.DrawerItems
import kotlinx.coroutines.CoroutineScope

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
    onHeaderClicked: CoroutineScope.() -> Unit,
    onDrawerClicked: (DrawerItems) -> Unit
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .wrapContentWidth()
            .fillMaxHeight()
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
            IconButton(onClick = { scope.onHeaderClicked() }) {
                Icon(tint = MaterialTheme.colorScheme.primary, imageVector = Icons.Default.MenuOpen, contentDescription = null)
            }
        }
        items.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(imageVector = item.image, contentDescription = stringResource(id = item.title)) },
                label = { Text(text = stringResource(id = item.title), modifier = Modifier.padding(horizontal = 16.dp)) },
                selected = selectedDestination.route == item.route,
                onClick = { onDrawerClicked(item) },
                colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent)
            )
        }
        Divider(thickness = Dp.Hairline, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        NavigationDrawerItem(
            selected = false,
            icon = { Icon(imageVector = DrawerItems.Refresh.image, contentDescription = stringResource(id = DrawerItems.Refresh.title)) },
            label = { Text(text = stringResource(id = DrawerItems.Refresh.title), modifier = Modifier.padding(horizontal = 16.dp)) },
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