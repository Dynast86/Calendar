package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import com.dynast.calendar.R

sealed class AlarmRepeatItems(
    @StringRes val title: Int,
) {
    object None : AlarmRepeatItems(title = R.string.alarm_repeat_none)
    object Day : AlarmRepeatItems(title = R.string.alarm_repeat_every_day)
    object Week : AlarmRepeatItems(title = R.string.alarm_repeat_every_week)
    object Month : AlarmRepeatItems(title = R.string.alarm_repeat_every_month)
    object Year : AlarmRepeatItems(title = R.string.alarm_repeat_every_year)
    object Config : AlarmRepeatItems(title = R.string.alarm_config)
}
