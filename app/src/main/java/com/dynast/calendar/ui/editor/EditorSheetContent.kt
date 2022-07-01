package com.dynast.calendar.ui.editor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dynast.calendar.R
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.presentation.main.state.EditUiState
import com.dynast.calendar.ui.components.dialog.RepeatPopup
import com.dynast.calendar.ui.components.editor.*

@Composable
fun EditorSheetContent(
    clear: Boolean,
    listState: LazyListState,
    editUiState: EditUiState,
    onClicked: ButtonType.() -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatPopup(defaultValue = repeatState, onChecked = { repeatState = this }) { functionRepeatDialogPopup = false }
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {
        item {
            HeaderTextField(
                modifier = Styled.defaultPadding,
                hint = stringResource(id = R.string.task_alt_hilt),
                clear = clear
            )
        }

        item { DateAddContent(modifier = Styled.defaultPadding, date = editUiState.date) { onClicked(this) } }
        item { UserAddContent(modifier = Styled.defaultPadding) { onClicked(this) } }
        item { MeetAddContent(modifier = Styled.defaultPadding, meet = editUiState.meet) }
        item { LocationAddContent(modifier = Styled.defaultPadding) { onClicked(this) } }
        item { AlarmAddContent(modifier = Styled.defaultPadding) { } }
        item { ColorAddContent(modifier = Styled.defaultPadding, defaultValue = editUiState.color) }
        item {
            ExplanationContent(modifier = Styled.defaultPadding, hint = stringResource(id = R.string.editor_explanation_add))
        }
        item { AttachFileContent(modifier = Styled.defaultPadding) { onClicked(this) } }
    }
}