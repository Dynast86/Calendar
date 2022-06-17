package com.dynast.calendar.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onBackClick: (String) -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    var dropdownState by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { onBackClick("Close") }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                },
                actions = {
                    IconButton(onClick = { onBackClick("Edit") }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                    Box {
                        IconButton(onClick = { dropdownState = true }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                            if (dropdownState) {
                                DropMenu(expanded = dropdownState, onDismiss = { dropdownState = false })
                            }
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            DetailContent()
        }
    }
}

@Composable
fun DropMenu(expanded: Boolean, onDismiss: () -> Unit) {
    DropdownMenu(
        modifier = Modifier.sizeIn(minWidth = 180.dp),
        expanded = expanded,
        onDismissRequest = { onDismiss() },
    ) {
        DropdownMenuItem(
            text = { Text("삭제") },
            onClick = { onDismiss() },
            leadingIcon = {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "삭제"
                )
            })
        DropdownMenuItem(
            text = { Text("Task에서 보기") },
            onClick = { onDismiss() },
            leadingIcon = {
                Icon(
                    Icons.Default.Task,
                    contentDescription = "Task에서 보기"
                )
            })
//        MenuDefaults.Divider()
//        DropdownMenuItem(
//            text = { Text("Send Feedback") },
//            onClick = { onDismiss() },
//            leadingIcon = {
//                Icon(
//                    Icons.Outlined.Email,
//                    contentDescription = null
//                )
//            },
//            trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    CalendarTheme {
        DetailScreen(onBackClick = {})
    }
}