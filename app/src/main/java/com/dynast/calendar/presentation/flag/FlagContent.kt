package com.dynast.calendar.presentation.flag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.objects.Flags
import com.dynast.calendar.ui.components.FlagCard
import com.dynast.calendar.ui.theme.CalendarTheme

val flagItems = listOf(
    Flags.Training, Flags.Improvement, Flags.FriendShip, Flags.OwnShip, Flags.Planned
)

@Composable
fun FlagContent(
    state: LazyListState
) {
    LazyColumn(
        state = state,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                text = stringResource(id = R.string.flag_title),
                style = MaterialTheme.typography.headlineMedium
            )
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp, start = 24.dp, end = 24.dp),
                text = stringResource(id = R.string.flag_content)
            )
        }
        items(flagItems) { FlagCard(flagItem = it) }
    }
}

@Preview
@Composable
fun FlagContentPreview() {
    CalendarTheme {
        FlagContent(state = rememberLazyListState())
    }
}