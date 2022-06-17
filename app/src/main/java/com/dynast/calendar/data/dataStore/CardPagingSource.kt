package com.dynast.calendar.data.dataStore

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dynast.calendar.data.dto.CardModel
import com.dynast.calendar.data.remote.toCard
import com.dynast.calendar.domain.model.card.AgendaCardData

class CardPagingSource(
    val cards: List<CardModel>
) : PagingSource<Int, AgendaCardData>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AgendaCardData> {
        return try {
            val page = params.key

            LoadResult.Page(data = cards.toCard(), prevKey = page, nextKey = page?.plus(1))
        } catch (e: Exception) {
            LoadResult.Error(throwable = Throwable("Paging Error"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AgendaCardData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}