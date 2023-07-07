package com.example.weather.data.model

import io.realm.RealmObject

open class Coord(
    var lon: Double? = null,
    var lat: Double? = null
): RealmObject()