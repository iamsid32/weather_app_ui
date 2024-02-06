package com.app.weatherapplication.composables.items_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.weatherapplication.model.HourlyWeatherModel
import com.app.weatherapplication.model.PerDayWeatherModel
import com.app.weatherapplication.model.WeatherDetailModel

@Composable
fun HourlyWeatherItemComposable(item: HourlyWeatherModel) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = item.hour,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            painterResource(item.drawableRes),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = item.temp+"\u00B0",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun PerDayWeatherItemComposable(item: PerDayWeatherModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.day,
            style = TextStyle(
                fontSize = 15.sp,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth(fraction = .3f)
                .wrapContentHeight()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = .5f)
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painterResource(item.drawableRes),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = item.weather,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .wrapContentHeight()
            )
        }
        Text(
            text = item.temp,
            style = TextStyle(
                fontSize = 15.sp,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth(fraction = .5f)
                .wrapContentHeight()
        )
    }
}

@Composable
fun WeatherDetailItemComposable(item: WeatherDetailModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction = .5f)
            .wrapContentHeight()
            .padding(horizontal = 5.dp, vertical = 5.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color(0xFFE7EBEE),
                    shape = RoundedCornerShape(20.dp)
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(all = 15.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Image(
                    painterResource(item.drawableRes),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(30.dp)
                        .align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(10.dp))
                val customText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    ) {
                        append("${item.value} ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    ) {
                        append("${item.unit}")
                    }
                }

                Text(
                    text = customText,
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )
            }
        }
    }
}