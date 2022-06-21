package com.dynast.calendar.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun DetailContent() {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = paddingStart, top = 4.dp),
            text = "내 할 일 목록",
            style = MaterialTheme.typography.bodySmall
        )
        DividerContent()
        DetailTitleContent(
            title = "타이틀",
            date = "1월 7일 금요일 · 오후 2:00~3:00",
            repeat = "매주 월요일 반복"
        )
        DividerContent()
        DetailMeetContent()
        DividerContent()
    }
}

@Composable
private fun DividerContent() {
    Divider(
        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
        startIndent = paddingStart, thickness = Dp.Hairline
    )
}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview() {
    CalendarTheme {
        DetailContent()
    }
}

val paddingStart = 54.dp
