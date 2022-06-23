package com.dynast.calendar.presentation.flag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dynast.calendar.ui.theme.CalendarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlagActivity : ComponentActivity() {
    companion object {
        val TAG: String = FlagActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    FlagScreen(onBackClick = { finish() })
                }
            }
        }
    }
}