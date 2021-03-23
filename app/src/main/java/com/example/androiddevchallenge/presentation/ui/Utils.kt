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
@file:Suppress("DEPRECATION")

package com.example.androiddevchallenge.presentation.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

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

@SuppressLint("SimpleDateFormat")
fun String.formattedToday(): String {
    val format = SimpleDateFormat("yyyy-MM-dd")
    var date: Date? = null

    try {
        date = format.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    val sdf = SimpleDateFormat("dd EEE")
    return if (date != null) "Today, ${sdf.format(date)}" else "Today"
}

@SuppressLint("SimpleDateFormat")
fun String.formattedTime(): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    var date: Date? = null

    try {
        date = format.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    val sdf = SimpleDateFormat("HH:mm")
    return if (date != null) sdf.format(date) else ""
}

@SuppressLint("SimpleDateFormat")
fun String.formattedDay(): String {
    val format = SimpleDateFormat("yyyy-MM-dd")
    var date: Date? = null

    try {
        date = format.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    val sdf = SimpleDateFormat("EEEE")
    return if (date != null) sdf.format(date) else ""
}

@SuppressLint("DefaultLocale")
fun Double.formattedValue(): String = java.lang.String.format("%.2f", this)

fun getImageFromType(type: String): Int {
    return when {
        type.isSunny() -> R.drawable.ic_sun
        type.isSnowy() -> R.drawable.ic_snow
        type.isDusty() -> R.drawable.ic_dust
        type.isRainy() -> R.drawable.ic_rain
        type.isCloudy() -> R.drawable.ic_cloud
        else -> R.drawable.ic_sun
    }
}

private fun String.isSunny() = this == "clear" || this == ""
private fun String.isSnowy() = this.contains("snow") || this == "hail"
private fun String.isDusty() = this == "dust" || this == "mist" || this == "fog" || this == "sandstorm"
private fun String.isRainy() = this.contains("rain") || this == "thunderstorm"
private fun String.isCloudy() = this.contains("cloud")
