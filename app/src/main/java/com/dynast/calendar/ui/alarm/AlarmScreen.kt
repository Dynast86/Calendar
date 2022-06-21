package com.dynast.calendar.ui.alarm

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.UiPopup
import com.dynast.calendar.ui.theme.CalendarTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    onClicked: (AlarmEnum) -> Unit,
    viewModel: AlarmViewModel = hiltViewModel()
) {
    var popupState by remember { mutableStateOf(false) }
    var backState by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec,
        rememberTopAppBarScrollState()
    )
    if (popupState) {
        UiPopup(onConfirm = { popupState = false }) {
            backState = false
            popupState = false
            onClicked(AlarmEnum.Close)
        }
    }

    BackHandler(enabled = backState) { popupState = true }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        if (backState) {
                            popupState = true
                        } else {
                            onClicked(AlarmEnum.Close)
                        }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                },
                actions = {
                    Button(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {
                            scope.launch {
                                Toast.makeText(context, "알림 제목을 입력해야 합니다.", Toast.LENGTH_SHORT).show()
                            }
                        }) { Text(text = "저장") }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            AlarmContent(onClicked = onClicked)
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