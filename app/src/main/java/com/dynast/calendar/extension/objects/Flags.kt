package com.dynast.calendar.extension.objects

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.ui.graphics.vector.ImageVector
import com.dynast.calendar.R

sealed class Flags(
    val image: ImageVector,
    @StringRes val title: Int,
    @StringRes val content: Int,
    val route: String
) {
    object Training : Flags(Icons.Default.ViewAgenda, title = R.string.flag_training_title, content = R.string.flag_training_content, "Training")
    object Improvement : Flags(Icons.Default.ViewAgenda, title = R.string.flag_improvement_title, content = R.string.flag_improvement_content, "Improvement")
    object FriendShip : Flags(Icons.Default.ViewAgenda, title = R.string.flag_friend_ship_title, content = R.string.flag_friend_ship_content, "FriendShip")
    object OwnShip : Flags(Icons.Default.ViewAgenda, title = R.string.flag_own_ship_title, content = R.string.flag_own_ship_content, "OwnShip")
    object Planned : Flags(Icons.Default.ViewAgenda, title = R.string.flag_planned_title, content = R.string.flag_planned_content, "Planned")
}
