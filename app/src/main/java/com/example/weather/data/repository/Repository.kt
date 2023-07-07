package com.example.weather.data.repository

import com.example.weather.data.model.WeatherResponse
import com.example.weather.data.network.response.Response
import com.example.weather.data.network.response.parse
import com.example.weather.data.network.service.WeatherService
import com.example.weather.ui.model.Weather
import io.realm.Realm
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class Repository(
    private val service: WeatherService,
    private val realm: Realm,
) {
    internal fun getWeather() = flow {
        emit(Response.Loading())
        val cache = realm.where(WeatherResponse::class.java).findFirst()
        if (cache == null) {
            emit(Response.Error<Weather>("No data cached"))
        } else {
            emitData(Response.Success(cache))
        }
    }.catch {
        emit(Response.Error(it.message.orEmpty()))
    }

    internal fun getWeatherFromApi(city: String) = flow {
        try {
            service.getWeather(city).parse {
                it.city = city
                emitData(Response.Success(it))
                realm.executeTransaction { realm ->
                    realm.insertOrUpdate(it)
                }
            }
        } catch (e: Exception) {
            emit(Response.Error<Weather>(e.message.orEmpty()))
        }
    }

    private fun emitData(response: Response<WeatherResponse>) = flow {
        response.data?.run {
            emit(Response.Success(
                Weather(
                    temp = main?.temp,
                    humidity = main?.humidity,
                    pressure = main?.pressure,
                    windSpeed = wind?.speed,
                    feelsLike = main?.feelsLike,
                    visibility = visibility,
                    city = city
                )
            ))
        }
    }
}