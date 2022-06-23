package com.dynast.calendar.presentation.alarm.state

import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import kotlinx.coroutines.CoroutineScope

@Stable
class AlarmState(
    var popupState: MutableState<Boolean>,
    var backState: MutableState<Boolean>,
    val scope: CoroutineScope,
    val scrollBehavior: TopAppBarScrollBehavior
)