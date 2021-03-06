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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.WeatherRepo
import com.example.androiddevchallenge.data.response.Current
import com.example.androiddevchallenge.data.response.Daily
import com.example.androiddevchallenge.data.response.Hourly
import com.example.androiddevchallenge.data.response.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class State {
    LOADING,
    FAILED,
    SUCCESS
}

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: WeatherRepo) : ViewModel() {

    var state: State by mutableStateOf(State.LOADING)
        private set

    var error: String by mutableStateOf("Unknown error")
        private set

    var weather: Current? by mutableStateOf(null)
        private set

    var timezone: String by mutableStateOf("")
        private set

    var dailyData: List<Daily> by mutableStateOf(emptyList())
        private set

    var hourlyData: List<Hourly> by mutableStateOf(emptyList())
        private set

    init {
        viewModelScope.launch {
            state = when (
                val uiState: UiState<WeatherData> =
                    repo.getForecast(37.97318668385807, 23.72477316213453)
            ) {
                is UiState.Failed -> {
                    error = uiState.message
                    State.FAILED
                }
                is UiState.Loading -> {
                    State.LOADING
                }
                is UiState.Success -> {
                    with(uiState) {
                        weather = data.current
                        timezone = data.timezone
                        dailyData = data.daily
                        hourlyData = data.hourly
                    }
                    State.SUCCESS
                }
            }
        }
    }
}
