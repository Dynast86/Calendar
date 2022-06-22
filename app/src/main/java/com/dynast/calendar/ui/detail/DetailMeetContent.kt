package com.dynast.calendar.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.components.paddingStart
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun DetailMeetContent() {
    Row(modifier = Modifier.padding(bottom = 4.dp)) {
        Box(
            modifier = Modifier.size(paddingStart)
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp),
                imageVector = Icons.Default.MeetingRoom, contentDescription = null
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp, top = 4.dp),
                text = "Google Meet(으)로 참여하기",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "meet.google.com/fy-awef-wefs",
                style = MaterialTheme.typography.bodySmall
            )
        }
        IconButton(onClick = { }) {
            Image(
                imageVector = Icons.Default.Share, contentDescription = "Share"
            )
        }
    }
}

@Preview
@Composable
fun DetailMeetContentPreview() {
    CalendarTheme {
        DetailMeetContent()
    }
}