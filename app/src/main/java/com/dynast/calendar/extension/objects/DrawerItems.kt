package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.dynast.calendar.R

sealed class DrawerItems(
    val image: ImageVector,
    @StringRes val title: Int,
    val route: String
) {
    object ViewAgenda : DrawerItems(Icons.Default.ViewAgenda, title = R.string.drawer_view_agenda, "ViewAgenda")
    object CalendarViewDay : DrawerItems(Icons.Default.CalendarViewDay, title = R.string.drawer_calendar_view_day, "CalendarViewDay")
    object ViewWeek : DrawerItems(Icons.Default.ViewWeek, title = R.string.drawer_view_week, "ViewWeek")
    object CalendarViewWeek : DrawerItems(Icons.Default.CalendarViewWeek, title = R.string.drawer_calendar_view_Week, "CalendarViewWeek")
    object CalendarViewMonth : DrawerItems(Icons.Default.CalendarViewMonth, title = R.string.drawer_calendar_view_month, "CalendarViewMonth")

    object Refresh : DrawerItems(Icons.Default.Refresh, title = R.string.drawer_refresh, "Refresh")
}