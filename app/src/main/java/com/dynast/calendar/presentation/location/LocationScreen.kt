package com.dynast.calendar.presentation.location

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    onBackClick: () -> Unit,
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.titleLarge,
                        value = textState,
                        onValueChange = { textState = it },
                        decorationBox = { innerTextField ->
                            if (textState.text.isEmpty()) {
                                Text(text = stringResource(id = R.string.editor_location_add))
                            }
                            innerTextField()
                        },
                    )
            },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Close")
                }
            },
            actions = {
                if (textState.text.isNotEmpty()) {
                    IconButton(onClick = { textState = TextFieldValue() }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = stringResource(id = R.string.delete))
                    }
                }
            }
        )
    }) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    CalendarTheme {
        LocationScreen(onBackClick = {})
    }
}
