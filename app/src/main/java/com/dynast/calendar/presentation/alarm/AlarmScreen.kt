package com.dynast.calendar.presentation.alarm

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.R
import com.dynast.calendar.extension.UiPopup
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.presentation.alarm.state.rememberAlarmState
import com.dynast.calendar.ui.theme.CalendarTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    viewModel: AlarmViewModel = hiltViewModel(),
    onClicked: ButtonType.() -> Unit,
) {
    val context = LocalContext.current
    val alarmState = rememberAlarmState()
    var clear by remember { mutableStateOf(false) }

    if (alarmState.popupState.value) {
        UiPopup(onConfirm = { alarmState.popupState.value = false }) {
            alarmState.backState.value = false
            alarmState.popupState.value = false
            clear = true
            onClicked(ButtonType.Close)
        }
    }
    val toastTitle = stringResource(id = R.string.alarm_name_confirm)

    BackHandler(enabled = alarmState.backState.value) { alarmState.popupState.value = true }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        if (alarmState.backState.value) {
                            alarmState.popupState.value = true
                        } else {
                            clear = true
                            onClicked(ButtonType.Close)
                        }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                },
                actions = {
                    Button(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {
                            alarmState.scope.launch {
                                Toast.makeText(context, toastTitle, Toast.LENGTH_SHORT).show()
                            }
                        }) { Text(text = stringResource(id = R.string.save)) }
                },
                scrollBehavior = alarmState.scrollBehavior
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            AlarmContent(clear = clear) { onClicked(this) }
        }
    }
}

@Preview
@Composable
fun AlarmScreenPreview() {
    CalendarTheme {
        AlarmScreen(onClicked = { })
    }
}