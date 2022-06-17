package com.dynast.calendar.ui.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun AlarmContent(
    modifier: Modifier = Modifier,
    onClicked: (AlarmEnum) -> Unit
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup { functionRepeatDialogPopup = false }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 16.dp),
            value = textState,
            onValueChange = { textState = it },
            decorationBox = { innerTextField ->
                if (textState.text.isEmpty()) {
                    Text(
                        text = "알림...",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                innerTextField()
            },
            maxLines = 1,
            textStyle = MaterialTheme.typography.headlineLarge
        )
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        AlarmDateContent(onClicked = onClicked)
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        AlarmRepeatContent(onClicked = {
            functionRepeatDialogPopup = true
        })
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