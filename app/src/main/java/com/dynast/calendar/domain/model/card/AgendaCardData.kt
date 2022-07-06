package com.dynast.calendar.domain.model.card

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgendaCardData(
    val title: String,
    val content: String,
    val imageUrl: String? = null
) : Parcelable
