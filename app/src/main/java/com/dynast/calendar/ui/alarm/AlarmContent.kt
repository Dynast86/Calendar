package com.dynast.calendar.ui.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.HeaderTextField
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun AlarmContent(
    modifier: Modifier = Modifier,
    onClicked: (ButtonType) -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = {
            repeatState = it
        }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        HeaderTextField(modifier = dividerModifier, hint = stringResource(id = R.string.alarms_hint))
        AlarmDateContent(modifier = dividerModifier, onClicked = onClicked)
        AlarmRepeatContent(
            modifier = dividerModifier,
            defaultValue = repeatState,
            onClicked = { functionRepeatDialogPopup = true })
//        RepeatDialogPopup {
//
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmContentPreview() {
    CalendarTheme {
        AlarmContent(onClicked = { })
    }
}

val dividerModifier = Modifier.padding(top = 8.dp, bottom = 8.dp)