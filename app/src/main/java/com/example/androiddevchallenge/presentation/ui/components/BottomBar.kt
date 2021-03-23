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
package com.example.androiddevchallenge.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.presentation.ui.HOME
import com.example.androiddevchallenge.presentation.ui.SEARCH
import com.example.androiddevchallenge.presentation.ui.SETTINGS
import java.util.Locale

@Composable
fun BottomBar(navController: NavHostController) {
    Surface(
        elevation = 8.dp,
        color = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            NavigationIcon(
                title = stringResource(R.string.home),
                icon = R.drawable.ic_home,
                modifier = Modifier.clickable { navController.navigate(HOME) }
            )
            NavigationIcon(
                title = stringResource(R.string.search),
                icon = R.drawable.ic_search,
                modifier = Modifier.clickable { navController.navigate(SEARCH) }
            )
            NavigationIcon(
                title = stringResource(R.string.settings),
                icon = R.drawable.ic_settings,
                modifier = Modifier.clickable { navController.navigate(SETTINGS) }
            )
        }
    }
}

@Composable
fun NavigationIcon(title: String, @DrawableRes icon: Int, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = icon),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
            contentDescription = stringResource(R.string.home),
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = title.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onBackground
        )
    }
}
