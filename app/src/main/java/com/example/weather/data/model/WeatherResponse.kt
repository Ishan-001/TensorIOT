package com.example.weather.data.model

import io.realm.RealmList
import io.realm.RealmObject

open class WeatherResponse(
	var visibility: Int? = null,
	var timezone: Int? = null,
	var main: Main? = null,
	var clouds: Clouds? = null,
	var sys: Sys? = null,
	var dt: Int? = null,
	var coord: Coord? = null,
	var metaData: RealmList<MetaData?>? = null,
	var name: String? = null,
	var cod: Int? = null,
	var id: Int? = null,
	var base: String? = null,
	var wind: Wind? = null
): RealmObject() {
	var city = ""
}

