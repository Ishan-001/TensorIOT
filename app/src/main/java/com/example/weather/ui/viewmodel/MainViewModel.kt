package com.example.weather.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.model.WeatherResponse
import com.example.weather.data.repository.Repository
import com.example.weather.ui.model.ScreenState
import com.example.weather.ui.model.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val screenState = mutableStateOf(ScreenState.Loading)
    val weather = mutableStateOf<Weather?>(null)

    var error = mutableStateOf<String?>(null)

    init {
        getWeather()
    }

    private fun getWeather() {
        repository.getWeather().onEach { response ->
            response.data.let { data ->
                weather.value = data
                screenState.value = ScreenState.Success
            }
            response.error?.let {
                screenState.value = ScreenState.Error
                error.value = it
            }
        }.launchIn(viewModelScope)
    }

    internal fun getWeatherFromApi(city: String) {
        repository.getWeatherFromApi(city).onEach { response ->
            response.data.let { data ->
                weather.value = data
                screenState.value = ScreenState.Success
            }
            response.error?.let {
                screenState.value = ScreenState.Error
                error.value = it
            }
        }.launchIn(viewModelScope)
    }
}