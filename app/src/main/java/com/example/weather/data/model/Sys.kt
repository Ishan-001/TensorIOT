package com.example.weather.data.model

import io.realm.RealmObject

open class Sys(
    var country: String? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var id: Int? = null,
    var type: Int? = null
): RealmObject()