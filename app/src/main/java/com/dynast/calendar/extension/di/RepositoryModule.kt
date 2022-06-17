package com.dynast.calendar.extension.di

import com.dynast.calendar.data.dataStore.MockupDataSource
import com.dynast.calendar.data.remote.MockupRepository
import com.dynast.calendar.data.remote.MockupRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMockupRepository(dataSource: MockupDataSource): MockupRepository =
        MockupRepositoryImpl(dataSource = dataSource)
}