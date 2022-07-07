package com.dynast.calendar.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.dynast.calendar.domain.dataStore.DataStoreManager
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.domain.useCase.GetCardsFlowUseCase
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.presentation.main.state.DrawerUiState
import com.dynast.calendar.presentation.main.state.EditUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val getCardsFlowUseCase: GetCardsFlowUseCase,
) : ViewModel() {
    private var _getPagingData: Flow<PagingData<AgendaCardData>>? = null
    val getPagingData get() = _getPagingData!!

    private var _state = MutableStateFlow(0)
    val state get() = _state

    private var _processState = MutableStateFlow(false)
    val processState get() = _processState

    var editState by mutableStateOf(EditUiState())
        private set

    var drawerState = mutableStateOf(DrawerUiState())
        private set

    init {
        viewModelScope.launch {
            _getPagingData = getCardsFlowUseCase()
            setProcessState(true)
        }
        getDrawerItemState()
    }

    fun setProcessState(value: Boolean) = viewModelScope.launch {
        _processState.emit(value)
        delay(2000L)
        _processState.emit(false)
    }

    fun removeItem(item: AgendaCardData?) {
        println("removeItem : $item")
    }

    private fun getDrawerItemState() = viewModelScope.launch {
        dataStoreManager.drawerItem.collect {
            drawerState.value = DrawerUiState(item = it)
        }
    }

    fun setDrawerItemState(item: DrawerItems) = viewModelScope.launch {
        dataStoreManager.setDrawerItem(item)
    }
}