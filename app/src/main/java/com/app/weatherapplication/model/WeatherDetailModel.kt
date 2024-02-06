package com.app.weatherapplication.model

import com.app.weatherapplication.R

data class WeatherDetailModel(
    var drawableRes:Int,
    var title:String,
    var value:String,
    var unit:String,
)

var listOfWeatherDetail = mutableListOf(
    WeatherDetailModel(
        drawableRes = R.drawable.ic_temperature,
        title = "Feels like",
        value = "16°",
        unit = "",
    ),
    WeatherDetailModel(
        drawableRes = R.drawable.ic_air,
        title = "W wind",
        value = "13",
        unit = "km/h",
    ),
    WeatherDetailModel(
        drawableRes = R.drawable.ic_humidity,
        title = "Humidity",
        value = "62",
        unit = "%",
    ),
    WeatherDetailModel(
        drawableRes = R.drawable.ic_uv,
        title = "UV",
        value = "0",
        unit = "Very weak",
    ),
    WeatherDetailModel(
        drawableRes = R.drawable.ic_visibility,
        title = "Visibility",
        value = "1",
        unit = "km",
    ),
    WeatherDetailModel(
        drawableRes = R.drawable.ic_air,
        title = "Air pressure",
        value = "1017",
        unit = "hPa",
    ),
)
