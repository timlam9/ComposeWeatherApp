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

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.ui.unit.dp

val STATUS_BAR_HEIGHT = 26.dp

var minBottomSheetHeight = 0.dp
var maxBottomSheetHeight = 0.dp

const val HOME = "home"
const val SEARCH = "search"
const val SETTINGS = "settings"

fun Window.makeTransparentStatusBar() {
    markAttributes(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
        true
    )
    decorView.systemUiVisibility = (
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        )
    markAttributes(
        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
        false
    )
    statusBarColor = Color.TRANSPARENT
    navigationBarColor = Color.TRANSPARENT
}

fun Window.markAttributes(bits: Int, value: Boolean) {
    val params = attributes
    if (value) {
        params.flags = params.flags or bits
    } else {
        params.flags = params.flags and bits.inv()
    }
    attributes = params
}
