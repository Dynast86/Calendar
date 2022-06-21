package com.dynast.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.objects.Flags
import com.dynast.calendar.ui.theme.CalendarTheme


@Composable
fun FlagCard(
    flagItem: Flags
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .sizeIn(minHeight = 180.dp)
        .clickable {}
        .background(Color.Gray),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)) {
            Text(
                text = stringResource(id = flagItem.title),
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
            Text(
                text = stringResource(id = flagItem.content),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.fab_background)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlagCardPreview() {
    CalendarTheme {
        FlagCard(flagItem = Flags.Training)
    }
}