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
package com.example.androiddevchallenge.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.presentation.ui.STATUS_BAR_HEIGHT
import com.example.androiddevchallenge.presentation.ui.components.BottomBar
import com.example.androiddevchallenge.presentation.ui.components.Navigation
import com.example.androiddevchallenge.presentation.ui.makeTransparentStatusBar
import com.example.androiddevchallenge.presentation.ui.maxBottomSheetHeight
import com.example.androiddevchallenge.presentation.ui.minBottomSheetHeight
import com.example.androiddevchallenge.presentation.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.makeTransparentStatusBar()

        setContent {
            MyTheme {
                MyApp(viewModel)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MyApp(viewModel: MainViewModel) {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.surface) {
        MainContent(navController, viewModel)
    }
}

@ExperimentalMaterialApi
@Composable
private fun MainContent(navController: NavHostController, viewModel: MainViewModel) {
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
            Navigation(navController, viewModel)
            BottomBar(navController)
        }
    }
}

@Composable
private fun BoxWithConstraintsScope.FindScreenSize() {
    minBottomSheetHeight = maxHeight / 3
    maxBottomSheetHeight = maxHeight - maxHeight / 8
}
