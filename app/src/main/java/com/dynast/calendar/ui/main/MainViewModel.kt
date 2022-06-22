package com.dynast.calendar.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.domain.useCase.GetCardsFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCardsFlowUseCase: GetCardsFlowUseCase,
) : ViewModel() {
    private var _getPagingData: Flow<PagingData<AgendaCardData>>? = null
    val getPagingData get() = _getPagingData!!

    private var _state = MutableStateFlow(0)
    val state get() = _state

    private var _processState = MutableStateFlow(false)
    val processState get() = _processState

    init {
        viewModelScope.launch {
            _getPagingData = getCardsFlowUseCase()
            setProcessState(true)
        }
    }

    fun setProcessState(value: Boolean) = viewModelScope.launch {
        _processState.emit(value)
        delay(2000L)
        _processState.emit(false)
    }
}