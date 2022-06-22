package com.dynast.calendar.ui.main.state

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Stable
class MainState(
    val drawerState: DrawerState,
    val snackBarHostState: SnackbarHostState,
    val fabState: MutableTransitionState<Boolean>,
    val taskAltState: ModalBottomSheetState,
    val editorState: ModalBottomSheetState,
)
