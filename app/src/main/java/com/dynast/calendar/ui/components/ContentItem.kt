package com.dynast.calendar.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ContentItem(
    icon: ImageVector? = null,
    title: String,
    options: @Composable () -> Unit,
    onClick: () -> Unit
) {
    val textPadding = if (icon != null) {
        Modifier.padding(top = 16.dp, bottom = 16.dp)
    } else {
        Modifier.padding(top = 16.dp, bottom = 16.dp, start = 72.dp, end = 16.dp)
    }
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.apply {
            Icon(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                imageVector = this, contentDescription = null
            )
        }

        Text(modifier = textPadding.weight(1f), text = title)
        options()
    }
}