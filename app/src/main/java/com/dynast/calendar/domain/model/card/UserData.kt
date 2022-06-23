package com.dynast.calendar.domain.model.card

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.dynast.calendar.extension.Styled
import java.io.Serializable

@Immutable
data class UserData(
    val circleColor: Color = Styled.random(),
    val name: String,
    val email: String,
    val imageUrl: String? = null
) : Serializable