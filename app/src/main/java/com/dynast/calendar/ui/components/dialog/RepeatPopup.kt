package com.dynast.calendar.ui.components.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.objects.AlarmRepeatItems
import com.dynast.calendar.presentation.alarm.repeatItems
import com.dynast.calendar.ui.components.DialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RepeatPopup(
    defaultValue: Int = 0,
    onChecked: Int.() -> Unit,
    onDismiss: () -> Unit
) {
    val selected by remember { mutableStateOf(defaultValue) }

    DialogPopup(onDismiss = onDismiss, content = {
        LazyColumn(modifier = Styled.defaultPadding) {
            itemsIndexed(repeatItems) { index: Int, item: AlarmRepeatItems ->
                ListItem(modifier = Modifier.clickable {
                    onChecked(index)
                    onDismiss()
                }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = item.title), modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        if (selected == index) {
                            Image(imageVector = Icons.Default.Check, contentDescription = "Check")
                        }
                    }
                }
            }
        }
    })
}

@Preview
@Composable
fun RepeatDialogPopupPreview() {
    CalendarTheme {
        RepeatPopup(defaultValue = 1, onChecked = {}) { }
    }
}