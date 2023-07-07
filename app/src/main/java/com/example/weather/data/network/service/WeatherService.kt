package com.example.weather.data.network.service

import com.example.weather.BuildConfig
import com.example.weather.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("APPID") appId: String = "68e0849e2278e59e44e67ee712a368e0"
    // Build config in production apps
    ) : Response<WeatherResponse>
}