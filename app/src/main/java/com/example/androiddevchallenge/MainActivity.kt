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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.components.BottomBar
import com.example.androiddevchallenge.ui.components.Navigation
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.makeTransparentStatusBar()

        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.surface) {
        MainContent(navController)
    }
}

@ExperimentalMaterialApi
@Composable
private fun MainContent(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(STATUS_BAR_HEIGHT)
        )
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            FindScreenSize()
            Navigation(navController)
            BottomBar(navController)
        }
    }
}

@Composable
private fun BoxWithConstraintsScope.FindScreenSize() {
    minBottomSheetHeight = maxHeight / 3
    maxBottomSheetHeight = maxHeight - maxHeight / 8
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
