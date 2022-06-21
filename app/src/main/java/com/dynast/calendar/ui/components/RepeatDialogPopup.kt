package com.dynast.calendar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dynast.calendar.ui.alarm.repeatItems
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepeatDialogPopup(
    defaultValue: Int = 0,
    onChecked: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    val selected by remember { mutableStateOf(defaultValue) }

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
                itemsIndexed(repeatItems) { index: Int, item: String ->
                    ListItem(modifier = Modifier.clickable {
                        onChecked(index)
                        onDismiss()
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item, modifier = Modifier.weight(1f),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            if (selected == index) {
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
        RepeatDialogPopup(defaultValue = 1, onChecked = {}) {

        }
    }
}