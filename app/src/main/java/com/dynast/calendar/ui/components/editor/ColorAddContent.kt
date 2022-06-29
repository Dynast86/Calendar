package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.objects.ColorPalette.*
import com.dynast.calendar.presentation.main.MainViewModel
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.components.dialog.ColorPopup
import com.dynast.calendar.ui.theme.CalendarTheme

val paletteItems = listOf(
    Tomato, Mandarin, Banana, Basil,
    Sage, Peacock, Blueberries, Lavender,
    Grape, Flamingo, Carbon, Default
)

@Composable
fun ColorAddContent(
    modifier: Modifier = Modifier,
    defaultValue: Int = 11
) {
    val model: MainViewModel = hiltViewModel()
    var selected by remember { mutableStateOf(defaultValue) }
    var functionDialogPopup by remember { mutableStateOf(false) }
    if (functionDialogPopup) {
        ColorPopup(defaultValue = selected, onChecked = {
            selected = this
        }) { functionDialogPopup = false }
    }

    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { functionDialogPopup = true },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 28.dp, end = 30.dp)
                    .size(14.dp)
                    .border(width = 2.dp, color = paletteItems[selected].color, shape = CircleShape)
                    .clip(CircleShape)
                    .background(paletteItems[selected].color)
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .weight(1f), text = stringResource(id = paletteItems[selected].title)
            )
        }
        DividerContent(modifier = modifier)
    }
}

@Preview
@Composable
fun EditorColorContentPreview() {
    CalendarTheme {
        ColorAddContent()
    }
}