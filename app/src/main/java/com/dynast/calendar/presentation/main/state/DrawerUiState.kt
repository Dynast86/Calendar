package com.dynast.calendar.presentation.main.state

import com.dynast.calendar.extension.objects.DrawerItems

data class DrawerUiState(
    var item: DrawerItems = DrawerItems.ViewAgenda
)