package com.dynast.calendar.ui.alarm

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.dynast.calendar.extension.UiPopup
import com.dynast.calendar.ui.components.RepeatDialogPopup
import com.dynast.calendar.ui.theme.CalendarTheme
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint

enum class AlarmEnum {
    Close, Date, Time
}

@AndroidEntryPoint
class AlarmActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AlarmScreen(onClicked = clickListener)
                }
            }
        }
    }

    private val clickListener = object : (AlarmEnum) -> Unit {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build()

        val timePicker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(1)
            .setMinute(0)
            .setTitleText("")
            .build()

        override fun invoke(item: AlarmEnum) {
            when (item) {
                AlarmEnum.Date -> {
                    datePicker.show(supportFragmentManager, item.toString())
                }
                AlarmEnum.Time -> {
                    timePicker.show(supportFragmentManager, item.toString())
                }
                AlarmEnum.Close -> finish()
            }
        }
    }
}