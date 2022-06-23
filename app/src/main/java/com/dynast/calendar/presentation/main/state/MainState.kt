package com.dynast.calendar.presentation.main.state

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import com.dynast.calendar.extension.type.BottomType

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Stable
class MainState(
    val drawerState: DrawerState,
    val snackBarHostState: SnackbarHostState,
    val fabState: MutableTransitionState<Boolean>,
    val bottomSheetState: ModalBottomSheetState,
    var bottomType: MutableState<BottomType>
)
