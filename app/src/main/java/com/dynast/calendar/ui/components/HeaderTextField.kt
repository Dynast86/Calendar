package com.dynast.calendar.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun HeaderTextField(
    hint: String
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 36.dp, end = 16.dp),
        value = textState,
        onValueChange = { textState = it },
        decorationBox = { innerTextField ->
            if (textState.text.isEmpty()) {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            innerTextField()
        },
        maxLines = 1,
        textStyle = MaterialTheme.typography.headlineLarge
    )
}

@Preview
@Composable
fun HeaderTextFieldPreview() {
    CalendarTheme {
        HeaderTextField(hint = "알림...")
    }
}