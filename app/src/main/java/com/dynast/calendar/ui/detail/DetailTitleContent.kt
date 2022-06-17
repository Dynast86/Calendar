package com.dynast.calendar.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun DetailTitleContent(
    title: String,
    date: String,
    repeat: String? = null
) {
    Row(modifier = Modifier.padding(bottom = 16.dp)) {
        Box(
            modifier = Modifier.size(paddingStart)
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, top = 6.dp)
                    .size(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Black)
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp, top = 4.dp),
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = date,
                style = MaterialTheme.typography.bodySmall
            )
            repeat?.apply {
                Text(
                    text = this,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailTitleContentPreview() {
    CalendarTheme {
        DetailTitleContent(
            title = "타이틀",
            date = "1월 7일 금요일 · 오후 2:00~3:00",
            repeat = "매주 월요일 반복"
        )
    }
}