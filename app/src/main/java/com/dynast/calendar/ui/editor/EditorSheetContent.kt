package com.dynast.calendar.ui.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.components.editor.*
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun EditorSheetContent(
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
        EditorDateContent(modifier = Styled.defaultPadding) { onClicked(this) }
        EditorUserContent(modifier = Styled.defaultPadding) { onClicked(this) }
        EditorMeetContent(modifier = Styled.defaultPadding)
        EditorLocationContent(modifier = Styled.defaultPadding) { onClicked(this) }
    }
}

@Preview(showBackground = true)
@Composable
fun EditorSheetContentPreview() {
    CalendarTheme {
        EditorSheetContent(clear = false) { }
    }
}