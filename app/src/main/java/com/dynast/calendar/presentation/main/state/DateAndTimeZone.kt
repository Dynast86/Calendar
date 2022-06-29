package com.dynast.calendar.presentation.main.state

import java.time.ZoneId
import java.util.*

data class DateAndTimeZone(
    // 시작일
    val startDate: Long? = null,
    // 종료일
    val endDate: Long? = null,
    // 종일
    val allDay: Boolean = false,
    // 표준시
    val timeZone: TimeZone = TimeZone.getTimeZone(ZoneId.systemDefault()),
    // 반복
    val repeat: Any? = null
)
