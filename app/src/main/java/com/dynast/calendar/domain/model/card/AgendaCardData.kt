package com.dynast.calendar.domain.model.card

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class AgendaCardData(
    val title: String,
    val content: String,
    val imageUrl: String? = null
) : Parcelable
