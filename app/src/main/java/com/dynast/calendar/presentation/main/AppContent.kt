package com.dynast.calendar.presentation.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.ui.components.TopBarAddOn
import com.dynast.calendar.ui.components.ViewAgendaCard
import com.dynast.calendar.ui.components.cardShape
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    paging: Flow<PagingData<AgendaCardData>>,
    viewModel: MainViewModel = hiltViewModel()
) {
    val process by viewModel.processState.collectAsState()
    val selected by remember { viewModel.drawerState }

    val listState = rememberLazyListState()
    val page = paging.collectAsLazyPagingItems()

    Box(modifier = modifier.fillMaxSize()) {
        Column {
            when (selected.item) {
                DrawerItems.ViewAgenda, DrawerItems.CalendarViewMonth -> Unit
                else -> {
                    TopBarAddOn(modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp))
                }
            }

            Box {
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items = page) { value ->
                        val dismissState = rememberDismissState()

                        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                            viewModel.removeItem(value)
                        }

                        SwipeToDismiss(
                            state = dismissState,
                            modifier = Modifier.padding(vertical = Dp(1f)),
                            directions = setOf(DismissDirection.EndToStart),
                            dismissThresholds = { direction -> FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f) },
                            background = {
                                val color by animateColorAsState(
                                    when (dismissState.targetValue) {
                                        DismissValue.Default -> Color.White
                                        else -> Color.Red
                                    }
                                )
                                val scale by animateFloatAsState(if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f)

                                Box(
                                    Modifier
                                        .clip(shape = cardShape)
                                        .fillMaxSize()
                                        .background(color)
                                        .padding(horizontal = Dp(20f)),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Icon(modifier = Modifier.scale(scale), imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
                                }
                            }) {
                            ViewAgendaCard(data = value)
                        }
                    }
                }
                if (process) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}