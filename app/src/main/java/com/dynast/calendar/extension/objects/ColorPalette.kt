package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.dynast.calendar.R

sealed class ColorPalette(
    @StringRes val title: Int,
    val color: Color
) {
    object Tomato : ColorPalette(title = R.string.color_palette_tomato, color = Color(0xffc41c00))
    object Mandarin : ColorPalette(title = R.string.color_palette_mandarin, color = Color(0xffff9800))
    object Banana : ColorPalette(title = R.string.color_palette_banana, color = Color(0xffffeb3b))
    object Basil : ColorPalette(title = R.string.color_palette_basil, color = Color(0xff00bfa5))
    object Sage : ColorPalette(title = R.string.color_palette_sage, color = Color(0xff1de9b6))
    object Peacock : ColorPalette(title = R.string.color_palette_peacock, color = Color(0xff42a5f5))
    object Blueberries : ColorPalette(title = R.string.color_palette_blueberries, color = Color(0xff0277bd))
    object Lavender : ColorPalette(title = R.string.color_palette_lavender, color = Color(0xffbbdefb))
    object Grape : ColorPalette(title = R.string.color_palette_grape, color = Color(0xffba68c8))
    object Flamingo : ColorPalette(title = R.string.color_palette_flamingos, color = Color(0xffffcdd2))
    object Carbon : ColorPalette(title = R.string.color_palette_carbon, color = Color(0xff9e9e9e))
    object Default : ColorPalette(title = R.string.color_palette_default, color = Color(0xffc5cae9))
}
