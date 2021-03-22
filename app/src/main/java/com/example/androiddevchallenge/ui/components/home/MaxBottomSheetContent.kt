package com.example.androiddevchallenge.ui.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun BoxWithConstraintsScope.MaxBottomSheetContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                Column {
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Text(
                        text = "7 days",
                        modifier = Modifier.padding(start = 20.dp),
                        color = MaterialTheme.colors.surface
                    )
                }
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Sunday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Monday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Tuesday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Wednesday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Thursday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Friday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                WeatherRowCard(
                    icon = R.drawable.ic_cloud,
                    title = "Saturday",
                    wind = "23",
                    temp = "32",
                    humidity = "54"
                )
            }
            item {
                Spacer(modifier = Modifier.padding(top = 120.dp))
            }
        }
    }
}