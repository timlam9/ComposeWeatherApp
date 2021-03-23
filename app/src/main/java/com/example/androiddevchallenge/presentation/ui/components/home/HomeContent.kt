/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.presentation.ui.components.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.presentation.activity.MainViewModel
import com.example.androiddevchallenge.presentation.activity.State
import com.example.androiddevchallenge.presentation.ui.formattedToday
import com.example.androiddevchallenge.presentation.ui.formattedValue
import com.example.androiddevchallenge.presentation.ui.getImageFromType
import com.example.androiddevchallenge.presentation.ui.minBottomSheetHeight
import com.example.androiddevchallenge.presentation.ui.theme.gold
import com.example.androiddevchallenge.presentation.ui.theme.transparent

@Composable
fun HomeContent(viewModel: MainViewModel, actionLeft: () -> Unit, actionRight: () -> Unit) {

    when (viewModel.state) {
        State.LOADING -> LoadingContent()
        State.FAILED -> FailedContent(viewModel.error)
        State.SUCCESS -> DataContent(viewModel, actionLeft, actionRight)
    }
}

@Composable
fun LoadingContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        CircularProgressIndicator()
    }
}

@Composable
fun FailedContent(error: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Text(
            text = error,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.error
        )
    }
}

@Composable
fun DataContent(viewModel: MainViewModel, actionLeft: () -> Unit, actionRight: () -> Unit) {
    val currentWeather = viewModel.weather
    val timeZone = viewModel.timezone

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = minBottomSheetHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        DateView(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp),
            date = currentWeather?.time ?: "",
            city = timeZone
        )
        WeatherImage(
            modifier = Modifier.weight(3f),
            image = getImageFromType(currentWeather?.type ?: ""),
            actionLeft = actionLeft,
            actionRight = actionRight
        )
        WeatherTitle(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth(),
            text = currentWeather?.type ?: ""
        )
        WeatherDetails(
            modifier = Modifier.weight(0.8f),
            wind = currentWeather?.windSpeed ?: 0.0,
            temp = currentWeather?.temperature ?: 0.0,
            humidity = currentWeather?.relHumidity ?: 0.0
        )
    }
}

@Composable
private fun DateView(modifier: Modifier, date: String, city: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Column {
            Text(
                text = date.formattedToday(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondary
            )
            Text(
                text = city,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = gold)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
private fun WeatherImage(
    modifier: Modifier,
    @DrawableRes image: Int,
    actionLeft: () -> Unit,
    actionRight: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(onClick = actionLeft, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.ArrowLeft, contentDescription = "Arrow left")
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
            modifier = Modifier
                .aspectRatio(1f)
                .weight(4f)
        )
        IconButton(onClick = actionRight, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.ArrowRight, contentDescription = "Arrow right")
        }
    }
}

@Composable
private fun WeatherTitle(modifier: Modifier, text: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4.copy(fontFamily = FontFamily.SansSerif),
            color = MaterialTheme.colors.primary,
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            transparent,
                            MaterialTheme.colors.surface
                        )
                    )
                )
        )
    }
}

@Composable
fun WeatherDetails(modifier: Modifier, wind: Double, temp: Double, humidity: Double) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        DoubleText("Wind", wind.formattedValue())
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .width(2.dp)
                .background(color = MaterialTheme.colors.secondary)
        )
        DoubleText("Temp", "${temp.formattedValue()}°C")
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .width(2.dp)
                .background(color = MaterialTheme.colors.secondary)
        )
        DoubleText("humidity", "${humidity.formattedValue()}%")
    }
}

@Composable
fun DoubleText(title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )
    }
}
