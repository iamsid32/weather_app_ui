package com.app.weatherapplication.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.weatherapplication.R
import com.app.weatherapplication.composables.items_composable.HourlyWeatherItemComposable
import com.app.weatherapplication.composables.items_composable.PerDayWeatherItemComposable
import com.app.weatherapplication.composables.items_composable.WeatherDetailItemComposable
import com.app.weatherapplication.extension.drawSunShadow
import com.app.weatherapplication.model.listOfHourlyWeather
import com.app.weatherapplication.model.listOfPerDayWeather
import com.app.weatherapplication.model.listOfWeatherDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppbar(){
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFDFE3E6))
            .shadow(elevation = 2.dp),
        title = {
            Text(
                text = "Varanasi",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Start,
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Image(
                    painterResource(R.drawable.ic_toolbar),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                )
            }
            IconButton(
                onClick = {}
            ) {
                Image(
                    painterResource(R.drawable.ic_hamburger),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                )
            }
        },
        colors = TopAppBarColors(
            containerColor = Color(0xFFDFE3E6),
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color(0xFFDFE3E6),
            scrolledContainerColor = Color(0xFFDFE3E6),
            titleContentColor = Color.Black,
        )
    )
}

@Composable
fun HourlyWeatherListComposable(){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(listOfHourlyWeather){ item->
            HourlyWeatherItemComposable(item)
        }
    }
}

@Composable
fun PerDayWeatherListComposable(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color(0xFFEFF3F6),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(all = 20.dp)
        ){
            Column(modifier = Modifier.wrapContentSize()) {
                listOfPerDayWeather.forEach { item->
                    PerDayWeatherItemComposable(item)
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(color = Color(0xFFDFE3E6))
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Text(
                    text = "15-day weather forecast",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeatherDetailListComposable(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp, bottom = 5.dp)
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(),
            maxItemsInEachRow = 2,
            content = {
                listOfWeatherDetail.forEach { item ->
                    WeatherDetailItemComposable(item)
                }
            }
        )
    }
}

@Composable
fun SunRiseAndSetCardComposable(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color(0xFFE7EBEE),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(all = 20.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painterResource(R.drawable.ic_sunrise),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Image(
                        painterResource(R.drawable.ic_sunset),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Canvas(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height

                    val path = Path().apply {
                        moveTo(0f, canvasHeight)
                        quadraticBezierTo(
                            x1 = canvasWidth / 2,
                            y1 = 0f,
                            x2 = canvasWidth,
                            y2 = canvasHeight
                        )
                    }
                    drawPath(path, SolidColor(Color(0xFFEFF3F6)), style = Stroke(width = 2.dp.toPx()))

                    val sunPosition = Offset(x = (canvasWidth / 1.5).toFloat(), y = (size.height/1.8).toFloat())
                    drawCircle(
                        SolidColor(Color(0xFFE6AB34)),
                        radius = 12.dp.toPx(),
                        center = sunPosition,
                    )
                    drawSunShadow(center = sunPosition, radius = 20.dp.toPx())
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Sunrise",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Light
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "07:12",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .wrapContentSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Sunset",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Light
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "17:33",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}