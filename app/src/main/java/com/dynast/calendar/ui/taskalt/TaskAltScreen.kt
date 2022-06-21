package com.dynast.calendar.ui.taskalt

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dynast.calendar.ui.alarm.AlarmDateContent
import com.dynast.calendar.ui.alarm.AlarmEnum
import com.dynast.calendar.ui.alarm.AlarmRepeatContent
import com.dynast.calendar.ui.components.HeaderTextField
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskAltScreen(
    state: ModalBottomSheetState,
    onClicked: (AlarmEnum) -> Unit
) {
    var repeatState by remember { mutableStateOf(0) }
    var functionRepeatDialogPopup by remember { mutableStateOf(false) }
    if (functionRepeatDialogPopup) {
        RepeatDialogPopup(defaultValue = repeatState, onChecked = {
            repeatState = it
        }) { functionRepeatDialogPopup = false }
    }


    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = if (state.currentValue == ModalBottomSheetValue.HalfExpanded) {
            MaterialTheme.shapes.large
        } else {
            RoundedCornerShape(0.dp)
        },
        sheetContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
//                    .size()
                ) {
                    TaskAltTopBar(modifier = Modifier.padding(4.dp), onClicked = onClicked)
                    HeaderTextField(hint = "제목 추가")
                    DividerContent()
                    TaskAltDetailContent()
                    DividerContent()
                    AlarmDateContent(onClicked = onClicked)
                    DividerContent()
                    AlarmRepeatContent(
                        defaultValue = repeatState,
                        onClicked = { functionRepeatDialogPopup = true })
                    DividerContent()
                }
            }
        }
    ) { }
}

@Composable
fun TaskAltTopBar(
    modifier: Modifier = Modifier,
    onClicked: (AlarmEnum) -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { onClicked(AlarmEnum.Close) }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        Text(text = "", modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = {
                        scope.launch {
                            Toast.makeText(context, "알림 제목을 입력해야 합니다.", Toast.LENGTH_SHORT).show()
                        }
                    }) { Text(text = "저장") }
            }
        )
    }
}

@Composable
private fun DividerContent() {
    Divider(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), thickness = Dp.Hairline,
        color = MaterialTheme.colorScheme.surfaceTint
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun TaskAltScreenPreview() {
    val taskAlt = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
    CalendarTheme {
        TaskAltScreen(state = taskAlt, onClicked = {})
    }
}

@Preview
@Composable
fun TaskAltTopBarPreview() {
    CalendarTheme {
        TaskAltTopBar(onClicked = {})
    }
}