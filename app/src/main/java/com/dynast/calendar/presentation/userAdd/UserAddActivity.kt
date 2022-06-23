package com.dynast.calendar.presentation.userAdd

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dynast.calendar.ui.theme.CalendarTheme

class UserAddActivity : ComponentActivity() {
    companion object {
        val TAG: String = UserAddActivity::class.java.simpleName
    }

    val viewModel: UserAddViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UserAddContent {
                        val intent = Intent().apply {
                            val item = viewModel.userAddState.value.addUsers
                            putExtra("users", item.map { it.name }.toTypedArray())
                        }
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                }
            }
        }
    }
}