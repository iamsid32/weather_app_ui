package com.app.weatherapplication.model

import com.app.weatherapplication.R

data class HourlyWeatherModel(
    var hour:String,
    var temp:String,
    var drawableRes:Int
)

val listOfHourlyWeather = mutableListOf<HourlyWeatherModel>(
    HourlyWeatherModel(
        hour = "Now",
        temp = "18",
        drawableRes = R.drawable.ic_cloud,
    ),
    HourlyWeatherModel(
        hour = "15:00",
        temp = "17",
        drawableRes = R.drawable.ic_foggy,
    ),
    HourlyWeatherModel(
        hour = "16:00",
        temp = "17",
        drawableRes = R.drawable.ic_cloudy,
    ),
    HourlyWeatherModel(
        hour = "17:00",
        temp = "16",
        drawableRes = R.drawable.ic_cloudy,
    ),
    HourlyWeatherModel(
        hour = "17:33",
        temp = "16",
        drawableRes = R.drawable.ic_raining,
    ),
    HourlyWeatherModel(
        hour = "18:00",
        temp = "15",
        drawableRes = R.drawable.ic_moon,
    ),
)
