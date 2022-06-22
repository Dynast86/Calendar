package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme


@Composable
fun EditorMeetContent(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable(enabled = !state, onClick = { state = true }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                imageVector = Icons.Default.Videocam, contentDescription = null
            )

            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = if (state) {
                        stringResource(id = R.string.editor_google_meet)
                    } else {
                        stringResource(id = R.string.editor_meet_add)
                    }
                )
                if (state) {
                    Text(text = "화상 회의 세부정보 추가됨")
                }
            }
            if (state) {
                IconButton(onClick = { state = false }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }
        }
        DividerContent(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun EditorMeetContentPreview() {
    CalendarTheme {
        EditorMeetContent()
    }
}