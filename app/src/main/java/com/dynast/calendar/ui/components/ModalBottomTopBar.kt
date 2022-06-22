package com.dynast.calendar.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.theme.CalendarTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    toast: String? = null,
    onClicked: ButtonType.() -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val toastTitle = toast ?: stringResource(id = R.string.alarm_name_confirm)

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    title?.apply { Text(text = this) }
                },
                navigationIcon = {
                    IconButton(onClick = { onClicked(ButtonType.Close) }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                },
                actions = {
                    Button(
                        modifier = modifier.padding(end = 8.dp),
                        onClick = {
                            scope.launch {
                                Toast.makeText(context, toastTitle, Toast.LENGTH_SHORT).show()
                            }
                        }) { Text(text = stringResource(id = R.string.save)) }
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = modifier.padding(contentPadding)) {
            content()
        }
    }
}

@Preview
@Composable
fun ModalBottomTopBarPreview() {
    CalendarTheme {
        ModalBottomTopBar(onClicked = {}, content = {})
    }
}