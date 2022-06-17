package com.dynast.calendar.data.remote

import androidx.paging.PagingData
import com.dynast.calendar.domain.model.card.AgendaCardData
import kotlinx.coroutines.flow.Flow

interface MockupRepository {

    suspend fun getCards(pageSize: Int): Flow<PagingData<AgendaCardData>>

}