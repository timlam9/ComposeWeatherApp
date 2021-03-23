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
package com.example.androiddevchallenge.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun BoxWithConstraintsScope.MinBottomSheetContent(action: () -> Unit) {
    val dividerWidth = maxWidth / 6
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(2.dp))
        Divider(
            modifier = Modifier
                .height(3.dp)
                .width(dividerWidth)
                .background(color = MaterialTheme.colors.secondary)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(start = 30.dp, end = 20.dp)
        ) {
            Text(
                text = "Today",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.surface
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Next 7 days",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.surface
                )
                IconButton(
                    onClick = action,
                    modifier = Modifier.aspectRatio(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowRight,
                        contentDescription = "",
                        tint = MaterialTheme.colors.surface
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 5.dp, top = 5.dp)
        ) {
            WeatherColumnCard(R.drawable.ic_cloud, "12:00", "34")
            WeatherColumnCard(R.drawable.ic_cloud, "12:00", "34")
            WeatherColumnCard(R.drawable.ic_cloud, "12:00", "34")
            WeatherColumnCard(R.drawable.ic_cloud, "12:00", "34")
        }
    }
}
