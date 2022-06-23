package com.dynast.calendar.presentation.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.extension.objects.AlarmRepeatItems
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme

val repeatItems = listOf(
    AlarmRepeatItems.None,
    AlarmRepeatItems.Day,
    AlarmRepeatItems.Week,
    AlarmRepeatItems.Month,
    AlarmRepeatItems.Year,
    AlarmRepeatItems.Config
)

@Composable
fun AlarmRepeatContent(
    modifier: Modifier = Modifier,
    defaultValue: Int = 0,
    onClicked: () -> Unit
) {
    Column {
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
                text = stringResource(id = repeatItems[defaultValue].title)
            )
        }
        DividerContent(modifier = modifier)
    }
}

@Preview
@Composable
fun AlarmRepeatContentPreview() {
    CalendarTheme {
        AlarmRepeatContent(onClicked = {})
    }
}