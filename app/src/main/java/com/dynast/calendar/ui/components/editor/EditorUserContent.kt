package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.ContentItem
import com.dynast.calendar.ui.components.DividerContent
import com.dynast.calendar.ui.theme.CalendarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorUserContent(
    modifier: Modifier = Modifier,
    onClicked: ButtonType.() -> Unit
) {
    Column {
        ContentItem(
            icon = Icons.Default.Group,
            title = stringResource(id = R.string.editor_user_add),
            options = { }) { onClicked(ButtonType.UserAdd) }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AssistChip(
                modifier = Modifier.padding(start = 72.dp),
                onClick = { onClicked(ButtonType.ViewAgenda) },
                label = { Text(text = stringResource(id = R.string.editor_view_event)) })
        }
        DividerContent(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun EditorUserContentPreview() {
    CalendarTheme {
        EditorUserContent(onClicked = {})
    }
}
