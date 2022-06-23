package com.dynast.calendar.ui.main.state

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dynast.calendar.extension.type.BottomType

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun rememberMainState(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    fabState: MutableTransitionState<Boolean> = remember { MutableTransitionState(initialState = false) },
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    bottomType: MutableState<BottomType> = remember { mutableStateOf(BottomType.Editor) }
): MainState = remember {
    MainState(
        drawerState = drawerState,
        snackBarHostState = snackBarHostState,
        fabState = fabState,
        bottomSheetState = bottomSheetState,
        bottomType = bottomType
    )
}