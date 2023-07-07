package com.example.weather.data.repository

import com.example.weather.data.network.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.Realm

@Module
@InstallIn(ViewModelComponent::class)
object WeatherRepositoryModule {
    @ViewModelScoped
    @Provides
    fun provideRepository(
        service: WeatherService,
        realm: Realm,
    ): Repository =
        Repository(service, realm)
}