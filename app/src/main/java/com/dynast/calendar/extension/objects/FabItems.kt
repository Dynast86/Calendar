package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.dynast.calendar.R

sealed class FabItems(
    val image: ImageVector,
    @StringRes val title: Int,
    val route: String
) {
    object Add : FabItems(Icons.Default.Add, title = R.string.blank, "Add")

    object Event : FabItems(Icons.Default.Event, title = R.string.event, "Event")
    object TaskAlt : FabItems(Icons.Default.TaskAlt, title = R.string.task_alt, "TaskAlt")
    object Alarms : FabItems(Icons.Default.AlarmAdd, title = R.string.alarms, "Alarms")
    object Flag : FabItems(Icons.Default.Flag, title = R.string.flag, "Flag")

    object Close : FabItems(Icons.Default.Close, title = R.string.blank, "Close")
}