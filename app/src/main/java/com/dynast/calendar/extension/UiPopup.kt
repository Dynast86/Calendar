package com.dynast.calendar.extension

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UiPopup(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier
            .sizeIn(minWidth = 280.dp, maxWidth = 560.dp)
            .wrapContentHeight(),
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = "이 알림을 삭제하시겠습니까?",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "삭제")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "계속 수정")
            }
        }
    )
}

@Preview
@Composable
fun UiPopupPreview() {
    UiPopup(onDismiss = {}, onConfirm = {})
}