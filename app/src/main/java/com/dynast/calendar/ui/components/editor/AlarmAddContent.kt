package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AlarmAddContent(
    modifier: Modifier = Modifier,
    onClicked: ButtonType.() -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                imageVector = Icons.Default.Alarm, contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .weight(1f), text = "30분 전"
            )
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = stringResource(id = R.string.delete))
            }
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 72.dp, end = 16.dp)
                    .weight(1f), text = "30분 전에 이메일(으)로"
            )
            IconButton(onClick = { onClicked(ButtonType.Close) }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = stringResource(id = R.string.delete))
            }
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 72.dp, end = 16.dp)
                    .weight(1f), text = stringResource(id = R.string.editor_alarm_add)
            )
        }
        DividerContent(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun EditorAlarmContentPreview() {
    CalendarTheme {
        AlarmAddContent(onClicked = {})
    }
}