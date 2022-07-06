package com.dynast.calendar.ui.components.editor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.objects.AlarmRepeatItems
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.presentation.main.state.DateAndTimeZone
import com.dynast.calendar.presentation.main.state.EditUiState
import com.dynast.calendar.ui.components.ContentItem
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun DateAddContent(
    modifier: Modifier = Modifier,
    uiState: EditUiState,
    repeatTitle: String,
    onClicked: ButtonType.() -> Unit
) {
    var state by remember { mutableStateOf(uiState.date.allDay) }
    val expand = remember { MutableTransitionState(initialState = !uiState.date.allDay) }

    Column {
        ContentItem(
            icon = Icons.Default.Schedule,
            title = stringResource(id = R.string.alarm_every_day),
            options = {
                Switch(modifier = Modifier.padding(end = 16.dp), checked = state,
                    onCheckedChange = {
                        state = it
                        expand.targetState = !it
                    })
            }) {
            state = !state
            expand.targetState = !state
        }
        ContentItem(
            title = "2022년 6월 22일 (수)",
            options = {
                if (!state) {
                    TextButton(onClick = { onClicked(ButtonType.Time) }) {
                        Text(text = "오후 4:00")
                    }
                }
            }) { onClicked(ButtonType.Date) }
        ContentItem(
            title = "2022년 6월 22일 (수)",
            options = {
                if (!state) {
                    TextButton(onClick = { onClicked(ButtonType.Time) }) {
                        Text(text = "오후 5:00")
                    }
                }
            }) { onClicked(ButtonType.Date) }
        // 표준시
        AnimatedVisibility(visibleState = expand) {
            ContentItem(
                icon = Icons.Default.Public,
                title = "한국 표준시",
                options = { }) { onClicked(ButtonType.TimeZone) }
        }
        // 반복
        ContentItem(
            icon = Icons.Default.Replay,
            title = repeatTitle
//            stringResource(id = repeatItems[repeatValue].title)
            ,
            options = { }) { onClicked(ButtonType.RepeatDialog) }
        DividerContent(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun EditorDateContentPreview() {
    CalendarTheme {
        DateAddContent(onClicked = {}, uiState = EditUiState(date = DateAndTimeZone()), repeatTitle = stringResource(id = AlarmRepeatItems.None.title))
    }
}