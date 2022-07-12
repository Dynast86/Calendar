package com.dynast.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.presentation.main.MainViewModel

@Composable
fun TopBarAddOn(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val itemState by remember { viewModel.drawerState }

    Box(modifier = modifier.background(color = MaterialTheme.colorScheme.primaryContainer)) {
        Row {
            Box(modifier = Modifier.size(56.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = 56.dp, maxHeight = 56.dp)
            ) {
                when (itemState.item) {
                    DrawerItems.ViewWeek -> {}
                    DrawerItems.CalendarViewWeek -> {}
                    else -> {
//                    CalendarViewDay
                        item { DayItemCard(day = "일") { } }
                        item { DayItemCard(day = "월") { } }
                        item { DayItemCard(day = "화") { } }
                        item { DayItemCard(day = "수") { } }
                        item { DayItemCard(day = "목") { } }
                        item { DayItemCard(day = "금") { } }
                        item { DayItemCard(day = "토") { } }
                        item { DayItemCard(day = "일") { } }
                        item { DayItemCard(day = "월") { } }
                        item { DayItemCard(day = "화") { } }
                        item { DayItemCard(day = "수") { } }
                        item { DayItemCard(day = "목") { } }
                        item { DayItemCard(day = "금") { } }
                        item { DayItemCard(day = "토") { } }
                    }
                }
            }
        }
    }
}

@Composable
fun DayItemCard(
    day: String,
    onClick: () -> Unit
) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = day,
                textAlign = TextAlign.Center, fontSize = 10.sp
            )
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .padding(4.dp)
                    .clip(shape = CircleShape)
                    .background(color = MaterialTheme.colorScheme.primary)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "8", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}