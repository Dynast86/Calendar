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
import com.dynast.calendar.presentation.alarm.AlarmDateContent
import com.dynast.calendar.presentation.alarm.AlarmRepeatContent
import com.dynast.calendar.ui.components.dialog.RepeatPopup
import com.dynast.calendar.ui.components.editor.ExplanationContent
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
        RepeatPopup(defaultValue = repeatState, onChecked = { repeatState = this }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        HeaderTextField(
            modifier = Styled.defaultPadding,
            hint = stringResource(id = R.string.task_alt_hilt),
            clear = clear
        )
        ExplanationContent(
            modifier = Styled.defaultPadding,
            hint = stringResource(id = R.string.task_alt_add_data)
        )
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