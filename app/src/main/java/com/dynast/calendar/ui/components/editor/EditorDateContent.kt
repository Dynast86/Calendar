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
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.alarm.repeatItems
import com.dynast.calendar.ui.components.ContentItem
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun EditorDateContent(
    modifier: Modifier = Modifier,
    repeatValue: Int = 0,
    onClicked: (ButtonType) -> Unit
) {
    var checked by remember { mutableStateOf(true) }
    var timeState by remember { mutableStateOf(false) }
    val expand = remember { MutableTransitionState(initialState = timeState) }

    Column {
        ContentItem(
            icon = Icons.Default.Schedule,
            title = stringResource(id = R.string.alarm_every_day),
            options = {
                Switch(modifier = Modifier.padding(end = 16.dp), checked = checked,
                    onCheckedChange = {
                        checked = it
                        timeState = !checked
                        expand.targetState = !it
                    })
            }) {
            checked = !checked
            timeState = !checked
            expand.targetState = !checked
        }
        ContentItem(
            title = "2022년 6월 22일 (수)",
            options = {
                if (timeState) {
                    TextButton(onClick = { onClicked(ButtonType.Time) }) {
                        Text(text = "오후 4:00")
                    }
                }
            }) { onClicked(ButtonType.Date) }
        ContentItem(
            title = "2022년 6월 22일 (수)",
            options = {
                if (timeState) {
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
            title = stringResource(id = repeatItems[repeatValue].title),
            options = { }) { onClicked(ButtonType.RepeatDialog) }
        DividerContent(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun EditorDateContentPreview() {
    CalendarTheme {
        EditorDateContent(onClicked = {})
    }
}