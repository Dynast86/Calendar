package com.dynast.calendar.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.extension.Styled
import com.dynast.calendar.extension.objects.ColorPalette
import com.dynast.calendar.ui.components.DialogPopup
import com.dynast.calendar.ui.components.editor.paletteItems
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorPopup(
    defaultValue: Int = 11,
    onChecked: Int.() -> Unit,
    onDismiss: () -> Unit
) {
    DialogPopup(
        onDismiss = onDismiss,
        content = {
            LazyColumn(modifier = Styled.defaultPadding) {
                itemsIndexed(paletteItems) { index: Int, item: ColorPalette ->
                    ListItem(
                        modifier = Modifier.clickable {
                            onChecked(index)
                            onDismiss()
                        },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .border(width = 4.dp, color = item.color, shape = CircleShape)
                                        .clip(CircleShape)
                                        .background(if (index == defaultValue) item.color else Color.Transparent)
                                )
                                Text(
                                    text = stringResource(id = item.title),
                                    modifier = Modifier.weight(1f).padding(start = 8.dp),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (index == defaultValue) MaterialTheme.colorScheme.primary else Color.Unspecified
                                )
                            }
                        })
                }
            }
        })
}

@Preview
@Composable
fun ColorPopupContentPreview() {
    CalendarTheme {
        ColorPopup(onChecked = {}) { }
    }
}