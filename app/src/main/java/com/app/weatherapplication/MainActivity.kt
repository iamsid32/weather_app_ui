package com.app.weatherapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.app.weatherapplication.composables.*
import com.app.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WeatherApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    WeatherScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            WeatherAppbar()
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFFDFE3E6))
                        .padding(top = it.calculateTopPadding()),
                ) {
                    LazyColumn {
                        item {
                            HourlyWeatherListComposable()
                        }
                        item {
                            PerDayWeatherListComposable()
                        }
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                            ) {
                                Text(
                                    text = "Weather Details",
                                    style = TextStyle(
                                        color = Color.Gray
                                    )
                                )
                            }
                        }
                        item {
                            WeatherDetailListComposable()
                        }
                        item {
                            SunRiseAndSetCardComposable()
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherApplicationTheme {
        WeatherScreen()
    }
}
