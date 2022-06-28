package com.dynast.calendar.ui.components.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.objects.AlarmDateItems
import com.dynast.calendar.extension.objects.AlarmDateItems.*
import com.dynast.calendar.ui.components.DialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme

val dateItems = listOf(
    BeforeFiveMin, BeforeTenMin, BeforeFifthMin, BeforeOneHour, BeforeOneDay, Config
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlarmPopup(
    onChecked: Int.() -> Unit,
    onDismiss: () -> Unit,
) {
    DialogPopup(
        onDismiss = onDismiss,
        content = {
            LazyColumn(modifier = Styled.defaultPadding) {
                itemsIndexed(dateItems) { index: Int, item: AlarmDateItems ->
                    ListItem(
                        modifier = Modifier.clickable {
                            onChecked(index)
                            onDismiss()
                        },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
//                            Checkbox(checked = false, onCheckedChange = {})
                                Text(text = stringResource(id = item.title), modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                            }
                        })
                }
            }
        })
}

@Preview
@Composable
fun AlarmPopupContentPreview() {
    CalendarTheme {
        AlarmPopup(onChecked = {}) {

        }
    }
}