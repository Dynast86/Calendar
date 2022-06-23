package com.dynast.calendar.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.components.paddingStart
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun DetailContent() {

    val modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = paddingStart, top = 4.dp),
            text = "내 할 일 목록",
            style = MaterialTheme.typography.bodySmall
        )
        DividerContent(modifier = modifier, padding = true)
        DetailTitleContent(
            title = "타이틀",
            date = "1월 7일 금요일 · 오후 2:00~3:00",
            repeat = "매주 월요일 반복"
        )
        DividerContent(modifier = modifier, padding = true)
        DetailMeetContent()
        DividerContent(modifier = modifier, padding = true)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview() {
    CalendarTheme {
        DetailContent()
    }
}
