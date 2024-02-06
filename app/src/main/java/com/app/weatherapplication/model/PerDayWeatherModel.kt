package com.app.weatherapplication.model

import com.app.weatherapplication.R

data class PerDayWeatherModel(
    var day:String,
    var drawableRes:Int,
    var weather:String,
    var temp:String,
)

var listOfPerDayWeather = mutableListOf(
    PerDayWeatherModel(
        day = "Today",
        drawableRes = R.drawable.ic_cloudy,
        weather = "Partly Cloud",
        temp = "18°/8°",
    ),
    PerDayWeatherModel(
        day = "Tomorrow",
        drawableRes = R.drawable.ic_foggy,
        weather = "Fog",
        temp = "21°/10°",
    ),
    PerDayWeatherModel(
        day = "Thu",
        drawableRes = R.drawable.ic_foggy,
        weather = "Fog",
        temp = "21°/12°",
    ),
    PerDayWeatherModel(
        day = "Fri",
        drawableRes = R.drawable.ic_foggy,
        weather = "Fog",
        temp = "22°/9°",
    ),
    PerDayWeatherModel(
        day = "Sat",
        drawableRes = R.drawable.ic_sunny,
        weather = "Sunny",
        temp = "20°/8°",
    ),
    PerDayWeatherModel(
        day = "Sun",
        drawableRes = R.drawable.ic_sunny,
        weather = "Sunny",
        temp = "19°/7°",
    ),
    PerDayWeatherModel(
        day = "Mon",
        drawableRes = R.drawable.ic_sunny,
        weather = "Sunny",
        temp = "19°/6°",
    ),
)
