package com.example.androiddevchallenge.ui.components.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.components.home.BottomSheet
import com.example.androiddevchallenge.ui.components.home.HomeContent

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    BottomSheet {
        HomeContent(
            actionLeft = {},
            actionRight = {}
        )
    }
}