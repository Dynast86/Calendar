package com.dynast.calendar.presentation.alarm.state

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarScrollState
import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberAlarmState(
    popupState: MutableState<Boolean> = remember { mutableStateOf(false) },
    backState: MutableState<Boolean> = remember { mutableStateOf(true) },
    scope: CoroutineScope = rememberCoroutineScope(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberSplineBasedDecay(),
        rememberTopAppBarScrollState()
    )
): AlarmState = remember {
    AlarmState(
        popupState = popupState,
        backState = backState,
        scope = scope,
        scrollBehavior = scrollBehavior
    )
}