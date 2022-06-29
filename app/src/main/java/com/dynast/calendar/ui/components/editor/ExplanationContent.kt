package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun ExplanationContent(
    modifier: Modifier = Modifier,
    hint: String
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 16.dp),
                imageVector = Icons.Default.Notes, contentDescription = "Notes"
            )
            BasicTextField(
                modifier = Modifier.weight(1f),
                value = textState, onValueChange = { textState = it },
                decorationBox = { innerTextField ->
                    if (textState.text.isEmpty()) {
                        Text(text = hint)
                    }
                    innerTextField()
                },
            )
        }
        DividerContent(modifier = modifier)
    }
}

@Preview
@Composable
fun TaskAltDetailContentPreview() {
    CalendarTheme {
        ExplanationContent(hint = stringResource(id = R.string.task_alt_add_data))
    }
}