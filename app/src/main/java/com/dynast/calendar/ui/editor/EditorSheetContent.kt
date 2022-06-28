package com.dynast.calendar.ui.editor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.RepeatPopup
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
        RepeatPopup(defaultValue = repeatState, onChecked = { repeatState = this }) { functionRepeatDialogPopup = false }
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            HeaderTextField(
                modifier = Styled.defaultPadding,
                hint = stringResource(id = R.string.task_alt_hilt),
                clear = clear
            )
        }
        item { EditorDateContent(modifier = Styled.defaultPadding) { onClicked(this) } }
        item { EditorUserContent(modifier = Styled.defaultPadding) { onClicked(this) } }
        item { EditorMeetContent(modifier = Styled.defaultPadding) }
        item { EditorLocationContent(modifier = Styled.defaultPadding) { onClicked(this) } }
        item { EditorAlarmContent(modifier = Styled.defaultPadding) { } }
        item { EditorColorContent(modifier = Styled.defaultPadding) }
    }
}

@Preview(showBackground = true)
@Composable
fun EditorSheetContentPreview() {
    CalendarTheme {
        EditorSheetContent(clear = false) { }
    }
}