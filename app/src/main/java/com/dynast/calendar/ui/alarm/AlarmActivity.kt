package com.dynast.calendar.ui.alarm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.dynast.calendar.extension.ButtonEnum
import com.dynast.calendar.ui.theme.CalendarTheme
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint

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

    private val clickListener = object : (ButtonEnum) -> Unit {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build()

        val timePicker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(1)
            .setMinute(0)
            .setTitleText("")
            .build()

        override fun invoke(item: ButtonEnum) {
            when (item) {
                ButtonEnum.Date -> {
                    datePicker.show(supportFragmentManager, item.toString())
                }
                ButtonEnum.Time -> {
                    timePicker.show(supportFragmentManager, item.toString())
                }
                ButtonEnum.Close -> finish()
            }
        }
    }
}