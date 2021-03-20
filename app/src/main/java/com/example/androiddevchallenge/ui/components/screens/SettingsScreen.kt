package com.example.androiddevchallenge.ui.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.SETTINGS

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text(text = SETTINGS)
    }
}