package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.ContentItem
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme


@Composable
fun LocationAddContent(
    modifier: Modifier = Modifier,
    onClicked: ButtonType.() -> Unit
) {
    Column {
        ContentItem(
            icon = Icons.Default.LocationOn,
            title = stringResource(id = R.string.editor_location_add),
            options = { }) { onClicked(ButtonType.Location) }
        DividerContent(modifier = modifier)
    }
}

@Preview
@Composable
fun EditorLocationContentPreview() {
    CalendarTheme {
        LocationAddContent(onClicked = {})
    }
}