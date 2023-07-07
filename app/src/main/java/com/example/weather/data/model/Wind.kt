package com.example.weather.data.model

import io.realm.RealmObject

open class Wind(
    var deg: Int? = null,
    var speed: Double? = null
): RealmObject()