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
package com.example.androiddevchallenge.presentation.ui.components.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.presentation.ui.formattedValue
import com.example.androiddevchallenge.presentation.ui.getImageFromType
import com.example.androiddevchallenge.presentation.ui.theme.whiteTransparent

@Composable
fun WeatherRowCard(
    type: String,
    title: String,
    wind: Double,
    temp: Double,
    humidity: Double
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 10.dp, bottom = 10.dp, end = 50.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = whiteTransparent),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            )
            WeatherDetailsSmall(
                modifier = Modifier.padding(start = 10.dp),
                wind = wind.formattedValue(),
                temp = temp.formattedValue(),
                humidity = humidity.formattedValue()
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = getImageFromType(type)),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
private fun WeatherDetailsSmall(modifier: Modifier, wind: String, temp: String, humidity: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        DoubleTextSmall("Wind", "$wind km/h")
        SpaceDivider()
        DoubleTextSmall("Temp", "$temp??C")
        SpaceDivider()
        DoubleTextSmall("humidity", "$humidity%")
    }
}

@Composable
private fun SpaceDivider() {
    Spacer(modifier = Modifier.padding(2.dp))
    Divider(
        modifier = Modifier
            .height(20.dp)
            .width(1.dp)
            .background(color = MaterialTheme.colors.surface)
    )
    Spacer(modifier = Modifier.padding(2.dp))
}

@Composable
private fun DoubleTextSmall(title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.surface
        )
    }
}
