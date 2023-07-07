package com.example.weather.data.model

import io.realm.RealmObject

open class MetaData(
    var icon: String? = null,
    var description: String? = null,
    var main: String? = null,
    var id: Int? = null
): RealmObject()