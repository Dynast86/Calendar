package com.dynast.calendar.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.ui.components.ViewAgendaCard
import kotlinx.coroutines.flow.Flow

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    progressState: Boolean,
    paging: Flow<PagingData<AgendaCardData>>? = null,
) {
    val listState = rememberLazyListState()
    val page = paging?.collectAsLazyPagingItems()

    Box(modifier = modifier.fillMaxSize()) {
        Column {
            if (progressState) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            } else {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Transparent,
                    trackColor = Color.Transparent
                )
            }
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (page == null) {
                    items(previewState()) { value -> ViewAgendaCard(data = value) }
                } else {
                    items(items = page) { value -> ViewAgendaCard(data = value) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    AppContent(
        progressState = false
    )
}

fun previewState(): List<AgendaCardData> {
    val items = mutableListOf<AgendaCardData>()
    repeat(50) {
        items.add(
            AgendaCardData(title = "Preview $it", content = "테스트 | 총 ${it}강")
        )
    }
    return items.toList()
}