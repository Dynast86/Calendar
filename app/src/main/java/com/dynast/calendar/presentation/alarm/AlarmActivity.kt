package com.dynast.calendar.presentation.alarm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.dynast.calendar.extension.type.ButtonType
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

    private val clickListener = object : (ButtonType) -> Unit {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build()

        val timePicker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(1)
            .setMinute(0)
            .build()

        override fun invoke(item: ButtonType) {
            when (item) {
                ButtonType.Date -> {
                    if (!datePicker.isVisible)
                        datePicker.show(supportFragmentManager, item.toString())
                }
                ButtonType.Time -> {
                    if (!timePicker.isVisible)
                        timePicker.show(supportFragmentManager, item.toString())
                }
                ButtonType.Close -> finish()
                else -> Unit
            }
        }
    }
}