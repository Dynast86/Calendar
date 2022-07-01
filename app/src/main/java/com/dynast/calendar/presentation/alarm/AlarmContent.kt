package com.dynast.calendar.presentation.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.dialog.RepeatPopup
import com.dynast.calendar.ui.components.editor.HeaderTextField
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun AlarmContent(
    modifier: Modifier = Modifier,
    clear: Boolean,
    onClicked: ButtonType.() -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatPopup(defaultValue = repeatState, onChecked = { repeatState = this }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        HeaderTextField(
            modifier = Styled.defaultPadding,
            hint = stringResource(id = R.string.alarms_hint),
            clear = clear
        )
        AlarmDateContent(modifier = Styled.defaultPadding) { onClicked(this) }
        AlarmRepeatContent(
            modifier = Styled.defaultPadding,
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
        AlarmContent(clear = false) { }
    }
}

