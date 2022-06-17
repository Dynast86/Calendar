package com.dynast.calendar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dynast.calendar.ui.theme.CalendarTheme

val repeatItems = listOf(
    "반복 안함", "매일", "매주", "매월", "매년", "맞춤설정..."
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepeatDialogPopup(
    onDismiss: () -> Unit
) {
    var selected by remember { mutableStateOf(repeatItems[0]) }

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Surface(
            modifier = Modifier
                .sizeIn(minWidth = 280.dp, maxWidth = 560.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface,
        ) {
            LazyColumn(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
                items(repeatItems) { item ->
                    ListItem(modifier = Modifier.clickable { selected = item }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = item, modifier = Modifier.weight(1f))
                            if (selected == item) {
                                Image(imageVector = Icons.Default.Check, contentDescription = "Check")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RepeatDialogPopupPreview() {
    CalendarTheme {
        RepeatDialogPopup { }
    }
}