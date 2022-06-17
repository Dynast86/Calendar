package com.dynast.calendar.ui.alarm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dynast.calendar.ui.theme.CalendarTheme
import dagger.hilt.android.AndroidEntryPoint

enum class AlarmEnum {
    Close, Date, Time
}

@AndroidEntryPoint
class AlarmActivity : ComponentActivity() {
    companion object {
        val TAG: String = AlarmActivity::class.java.simpleName
    }

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
        override fun invoke(item: AlarmEnum) {
            when (item) {
                AlarmEnum.Date -> {
                    Log.e(TAG, item.toString())
                }
                AlarmEnum.Time -> {
                    Log.e(TAG, item.toString())
                }
                AlarmEnum.Close -> finish()
            }
        }
    }
}