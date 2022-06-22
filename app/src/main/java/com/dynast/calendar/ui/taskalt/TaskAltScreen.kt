package com.dynast.calendar.ui.taskalt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.alarm.AlarmDateContent
import com.dynast.calendar.ui.alarm.AlarmRepeatContent
import com.dynast.calendar.ui.components.HeaderTextField
import com.dynast.calendar.ui.components.ModalBottomTopBar
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskAltScreen(
    state: ModalBottomSheetState,
    onClicked: (ButtonType, ModalBottomSheetState) -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = if (state.currentValue == ModalBottomSheetValue.HalfExpanded) {
            MaterialTheme.shapes.large
        } else {
            RoundedCornerShape(0.dp)
        },
        sheetContent = {
            ModalBottomTopBar(
                onClicked = { enum -> onClicked(enum, state) }
            ) {
                TaskAltSheetContent(onClicked = { enum -> onClicked(enum, state) })
            }
        }
    ) { }
}

@Composable
fun TaskAltSheetContent(
    onClicked: (ButtonType) -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = {
            repeatState = it
        }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTextField(modifier = dividerModifier, hint = stringResource(id = R.string.task_alt_hilt))
        TaskAltDetailContent(modifier = dividerModifier)
        AlarmDateContent(onClicked = onClicked)
        AlarmRepeatContent(
            modifier = dividerModifier,
            defaultValue = repeatState,
            onClicked = { functionRepeatDialogPopup = true })
    }
}

@Preview(showBackground = true)
@Composable
fun TaskAltSheetContentPreview() {
    CalendarTheme {
        TaskAltSheetContent(onClicked = {})
    }
}

val dividerModifier = Modifier.padding(top = 8.dp, bottom = 8.dp)