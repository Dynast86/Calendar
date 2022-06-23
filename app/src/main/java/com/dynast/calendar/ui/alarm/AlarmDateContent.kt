package com.dynast.calendar.ui.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme


@Composable
fun AlarmDateContent(
    modifier: Modifier = Modifier,
    onClicked: ButtonType.() -> Unit
) {
    var checked by remember { mutableStateOf(true) }
    var timeState by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable {
                    checked = !checked
                    timeState = !checked
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                imageVector = Icons.Default.Schedule, contentDescription = "Schedule"
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .weight(1f),
                text = stringResource(id = R.string.alarm_every_day)
            )
            Switch(modifier = Modifier.padding(end = 16.dp), checked = checked,
                onCheckedChange = {
                    checked = it
                    timeState = !checked
                })
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { onClicked(ButtonType.Date) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 72.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
                    .weight(1f),
                text = "2022년 6월 17일 (금)"
            )
            if (timeState) {
                TextButton(onClick = { onClicked(ButtonType.Time) }) {
                    Text(text = "오후 6:00")
                }
            }
        }
        DividerContent(modifier = modifier)
    }
}

@Preview
@Composable
fun AlarmDateContentPreview() {
    CalendarTheme {
        AlarmDateContent(onClicked = {})
    }
}