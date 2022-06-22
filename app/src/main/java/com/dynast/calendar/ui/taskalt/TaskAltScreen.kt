package com.dynast.calendar.ui.taskalt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.ButtonEnum
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
    onClicked: (ButtonEnum) -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = {
            repeatState = it
        }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTextField(hint = stringResource(id = R.string.task_alt_hilt))
        DividerContent()
        TaskAltDetailContent()
        DividerContent()
        AlarmDateContent(onClicked = onClicked)
        DividerContent()
        AlarmRepeatContent(defaultValue = repeatState, onClicked = { functionRepeatDialogPopup = true })
        DividerContent()
    }
}

@Preview(showBackground = true)
@Composable
fun TaskAltSheetContentPreview() {
    CalendarTheme {
        TaskAltSheetContent(onClicked = {})
    }
}

@Composable
private fun DividerContent() {
    Divider(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
        color = MaterialTheme.colorScheme.surfaceTint
    )
}