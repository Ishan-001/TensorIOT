package com.example.weather.data.network.response

sealed class Response<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Success<T>(data: T) : Response<T>(data = data)
    class Error<Any>(message: String) : Response<Any>(error = message)
    class Loading<Unit> : Response<Unit>()

}