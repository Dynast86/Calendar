package com.dynast.calendar.domain.dataStore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.dynast.calendar.extension.Constants
import com.dynast.calendar.extension.objects.DrawerItems
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("settings")

class DataStoreManager @Inject constructor(
    @ApplicationContext context: Context
) {
    companion object {
        val TAG: String = DataStoreManager::class.java.simpleName
    }

    private val settingsDataStore = context.dataStore

    suspend fun setDrawerItem(value: DrawerItems) = settingsDataStore.edit { settings ->
        settings[Constants.drawerItem] = value.route
    }

    val drawerItem: Flow<DrawerItems> = settingsDataStore.data.map { value: Preferences ->
        when (value[Constants.drawerItem]) {
            "CalendarViewDay" -> DrawerItems.CalendarViewDay
            "ViewWeek" -> DrawerItems.ViewWeek
            "CalendarViewWeek" -> DrawerItems.CalendarViewWeek
            "CalendarViewMonth" -> DrawerItems.CalendarViewMonth
            else -> DrawerItems.ViewAgenda
        }
    }
}