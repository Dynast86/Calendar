package com.dynast.calendar.extension

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun UiPopup(
    title: String? = null,
    content: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        confirmButton = {
//            TextButton(onClick = onConfirm) {
//                Text(text = "계속 수정")
//            }
//        }
//    ) {
//
//    }
}