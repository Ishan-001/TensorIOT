package com.example.weather.data.model

import io.realm.RealmObject

open class Main(
    var temp: Double? = null,
    var tempMin: Double? = null,
    var humidity: Int? = null,
    var pressure: Int? = null,
    var feelsLike: Double? = null,
    var tempMax: Double? = null
): RealmObject()