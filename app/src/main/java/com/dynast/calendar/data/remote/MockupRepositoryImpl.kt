package com.dynast.calendar.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.dynast.calendar.data.dataStore.CardPagingSource
import com.dynast.calendar.data.dataStore.MockupDataSource
import com.dynast.calendar.data.dto.CardModel
import com.dynast.calendar.domain.model.card.AgendaCardData
import javax.inject.Inject

class MockupRepositoryImpl @Inject constructor(
    private val dataSource: MockupDataSource,
) : MockupRepository {

    override suspend fun getCards(pageSize: Int) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = false
        )
    ) {
        CardPagingSource(dataSource.cards)
    }.flow
}

fun List<CardModel>.toCard(): List<AgendaCardData> = map {
    AgendaCardData(title = it.title, content = it.content, imageUrl = it.imageUrl)
}