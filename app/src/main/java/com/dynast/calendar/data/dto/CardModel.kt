package com.dynast.calendar.data.dto

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Immutable
data class CardModel(
    val title: String,
    val content: String,
    val imageUrl: String? = null
) : Parcelable