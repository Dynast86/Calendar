package com.dynast.calendar.data.dto

import androidx.compose.runtime.Immutable

@Immutable
data class CardModel(
    val title: String,
    val content: String,
    val imageUrl: String? = null
)