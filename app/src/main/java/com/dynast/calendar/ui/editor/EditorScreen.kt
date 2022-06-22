package com.dynast.calendar.ui.editor

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dynast.calendar.extension.ButtonEnum
import com.dynast.calendar.ui.components.ModalBottomTopBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditorScreen(
    state: ModalBottomSheetState,
    onClicked: (ButtonEnum, ModalBottomSheetState) -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = if (state.currentValue == ModalBottomSheetValue.HalfExpanded) {
            MaterialTheme.shapes.large
        } else {
            RoundedCornerShape(0.dp)
        },
        sheetContent = {
            ModalBottomTopBar(onClicked = { enum -> onClicked(enum, state) }, title = "EditorScreen") {
                EditorSheetContent(onClicked = { enum -> onClicked(enum, state) })
            }
        }
    ) { }
}

@Composable
fun EditorSheetContent(
    onClicked: (ButtonEnum) -> Unit
) {

}