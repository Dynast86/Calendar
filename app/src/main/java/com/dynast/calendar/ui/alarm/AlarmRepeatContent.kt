package com.dynast.calendar.ui.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.theme.CalendarTheme

val repeatItems = listOf(
    "반복 안함", "매일", "매주", "매월", "매년", "맞춤설정..."
)

@Composable
fun AlarmRepeatContent(
    defaultValue: Int = 0,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            imageVector = Icons.Default.Replay, contentDescription = "Repeat"
        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .weight(1f),
            text = repeatItems[defaultValue]
        )
    }
}

@Preview
@Composable
fun AlarmRepeatContentPreview() {
    CalendarTheme {
        AlarmRepeatContent(onClicked = {})
    }
}