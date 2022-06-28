package com.dynast.calendar.presentation.userAdd

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.UserAddType
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAddContent(
    viewModel: UserAddViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val uiState by viewModel.userAddState.collectAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.titleLarge,
                        value = textState,
                        onValueChange = {
                            textState = it
                            uiState.filteredUsers(text = textState.text)
                        },
                        decorationBox = { innerTextField ->
                            if (textState.text.isEmpty()) {
                                Text(text = stringResource(id = R.string.editor_user_add))
                            }
                            innerTextField()
                        },
                        maxLines = 1,
                        singleLine = true,
                    )
                },
                navigationIcon = {
                    Spacer(modifier = Modifier.size(48.dp))
                },
                actions = {
                    if (textState.text.isNotEmpty()) {
                        IconButton(onClick = { textState = TextFieldValue() }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = stringResource(id = R.string.delete))
                        }
                    } else {
                        TextButton(onClick = onBackClick) { Text(text = stringResource(id = R.string.completion)) }
                    }
                }
            )
        }) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            UserAddItems(textState = textState, uiState = uiState) { item ->
                when (this) {
                    UserAddType.SELECT -> {
                        uiState.addUsers(item)
                        textState = TextFieldValue()
                    }
                    UserAddType.DELETE -> uiState.deleteUsers(item)
                }

            }
        }
    }
}

@Preview
@Composable
fun UserAddContentPreview() {
    CalendarTheme {
        UserAddContent { }
    }
}