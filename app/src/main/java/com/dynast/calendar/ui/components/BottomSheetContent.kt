package com.dynast.calendar.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent(
    state: ModalBottomSheetState,
    titleState: Boolean = false,
    onClicked: ModalBottomSheetState.(ButtonType) -> Unit,
    content: @Composable (Boolean) -> Unit
) {
    var clear by remember { mutableStateOf(false) }
    val shape = if (state.currentValue == ModalBottomSheetValue.HalfExpanded) {
        MaterialTheme.shapes.large
    } else {
        RoundedCornerShape(0.dp)
    }

    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = shape,
        sheetContent = {
            ModalBottomTopBar(
                onClicked = {
                    state.onClicked(this)
                    if (this == ButtonType.Close) clear = true
                }) { content(clear) }
        }
    ) { }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun BottomSheetContentPreview() {
    CalendarTheme {
        BottomSheetContent(state = ModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded), onClicked = {}) { }
    }
}