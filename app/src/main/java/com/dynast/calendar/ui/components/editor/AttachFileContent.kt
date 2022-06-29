package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dynast.calendar.R
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.components.ContentItem
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun AttachFileContent(
    modifier: Modifier = Modifier,
    onClicked: ButtonType.() -> Unit
) {
    Column {
        ContentItem(
            icon = Icons.Default.AttachFile,
            title = stringResource(id = R.string.editor_attach_file_add),
            options = { }) { onClicked(ButtonType.AttachFile) }
        Box(modifier = modifier)
    }
}

@Preview
@Composable
fun AttachFileContentPreview() {
    CalendarTheme {
        AttachFileContent(onClicked = {})
    }
}