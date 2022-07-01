package com.dynast.calendar.domain.useCase

import androidx.paging.PagingData
import com.dynast.calendar.data.remote.MockupRepository
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.extension.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCardsFlowUseCase @Inject constructor(
    private val repository: MockupRepository,
    @IoDispatcher val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<PagingData<AgendaCardData>> = callbackFlow {
        withContext(coroutineDispatcher) {
            repository.getCards(20).collectLatest {
                trySend(it)
            }
        }
    }
}