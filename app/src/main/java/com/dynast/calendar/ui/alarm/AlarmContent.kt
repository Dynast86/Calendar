package com.dynast.calendar.ui.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.components.HeaderTextField
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun AlarmContent(
    modifier: Modifier = Modifier,
    onClicked: (AlarmEnum) -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = {
            repeatState = it
        }) { functionRepeatDialogPopup = false }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        HeaderTextField(hint = "알림...")
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        AlarmDateContent(onClicked = onClicked)
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        AlarmRepeatContent(
            defaultValue = repeatState,
            onClicked = { functionRepeatDialogPopup = true })
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
            color = MaterialTheme.colorScheme.surfaceTint
        )
//        RepeatDialogPopup {
//
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmContentPreview() {
    CalendarTheme {
        AlarmContent(onClicked = { })
    }
}