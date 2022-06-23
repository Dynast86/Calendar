package com.dynast.calendar.presentation.location

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dynast.calendar.ui.theme.CalendarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationActivity : ComponentActivity() {
    companion object {
        val TAG: String = LocationActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationPermissionRequest.launch(
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION)
        )

        setContent {
            CalendarTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    FlagScreen(onBackClick = { finish() })
                    LocationScreen(onBackClick = { finish() })
                }
            }
        }
    }

    private val locationPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                // Only approximate location access granted.
            }
            else -> {
                // No location access granted.
            }
        }
    }
}