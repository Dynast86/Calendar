package com.dynast.calendar.ui.taskalt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.alarm.AlarmDateContent
import com.dynast.calendar.ui.alarm.AlarmRepeatContent
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.components.editor.HeaderTextField
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun TaskAltSheetContent(
    clear: Boolean,
    onClicked: ButtonType.() -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = { repeatState = this }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTextField(
            modifier = Styled.defaultPadding,
            hint = stringResource(id = R.string.task_alt_hilt),
            clear = clear
        )
        TaskAltDetailContent(modifier = Styled.defaultPadding)
        AlarmDateContent { onClicked(this) }
        AlarmRepeatContent(
            modifier = Styled.defaultPadding,
            defaultValue = repeatState
        ) { functionRepeatDialogPopup = true }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskAltSheetContentPreview() {
    CalendarTheme {
        TaskAltSheetContent(clear = false) { }
    }
}