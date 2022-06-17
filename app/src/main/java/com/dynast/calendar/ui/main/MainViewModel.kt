package com.dynast.calendar.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.domain.useCase.GetCardsFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCardsFlowUseCase: GetCardsFlowUseCase,
) : ViewModel() {
    companion object {
        val TAG: String = MainViewModel::class.java.simpleName
    }

    private var _getPagingData: Flow<PagingData<AgendaCardData>>? = null
    val getPagingData get() = _getPagingData!!

    init {
        viewModelScope.launch {
            _getPagingData = getCardsFlowUseCase()
        }
    }
}