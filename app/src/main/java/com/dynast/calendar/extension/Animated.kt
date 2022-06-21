package com.dynast.calendar.extension

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset

object Animated {
    fun slideEnter() = slideIn(
        initialOffset = { IntOffset(0, y = (it.height / 4)) },
        animationSpec = spring(
            stiffness = Spring.StiffnessMedium,
            visibilityThreshold = IntOffset.VisibilityThreshold
        )
    )

    fun slideExit() = slideOut(
        targetOffset = { IntOffset(0, y = (it.height / 4)) },
        animationSpec = spring(
            stiffness = Spring.StiffnessMedium,
            visibilityThreshold = IntOffset.VisibilityThreshold
        )
    )
}