package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import com.dynast.calendar.R

sealed class AlarmDateItems(
    @StringRes val title: Int,
) {
    object BeforeFiveMin : AlarmDateItems(title = R.string.alarm_before_five_minute)
    object BeforeTenMin : AlarmDateItems(title = R.string.alarm_before_ten_minute)
    object BeforeFifthMin : AlarmDateItems(title = R.string.alarm_before_fifth_minute)
    object BeforeOneHour : AlarmDateItems(title = R.string.alarm_before_one_hour)
    object BeforeOneDay : AlarmDateItems(title = R.string.alarm_before_one_day)
    object Config : AlarmDateItems(title = R.string.alarm_config)
}
