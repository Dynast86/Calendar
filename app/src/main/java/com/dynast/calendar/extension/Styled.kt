package com.dynast.calendar.extension

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

object Styled {
    val defaultPadding = Modifier.padding(top = 8.dp, bottom = 8.dp)

    fun random(): Color {
        return Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256)
        )
    }
}