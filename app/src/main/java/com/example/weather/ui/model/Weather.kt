package com.example.weather.ui.model


data class Weather(
    val city: String,
    val temp: Double?,
    val humidity: Int?,
    val pressure: Int?,
    val windSpeed: Double?,
    val visibility: Int?,
    val feelsLike: Double?
)