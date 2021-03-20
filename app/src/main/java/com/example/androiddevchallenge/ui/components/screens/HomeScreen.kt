package com.example.androiddevchallenge.ui.components.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.maxBottomSheetHeight
import com.example.androiddevchallenge.minBottomSheetHeight
import com.example.androiddevchallenge.ui.components.home.HomeContent
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    val coroutineScope = rememberCoroutineScope()
    BottomSheet { bottomSheetScaffoldState ->
        HomeContent(
            actionLeft = {
                coroutineScope.launch {
                    changeBottomSheetState(bottomSheetScaffoldState)
                }
            },
            actionRight = {
                coroutineScope.launch {
                    changeBottomSheetState(bottomSheetScaffoldState)
                }
            }
        )
    }
}

@ExperimentalMaterialApi
private suspend fun changeBottomSheetState(bottomSheetScaffoldState: BottomSheetScaffoldState) {
    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
        bottomSheetScaffoldState.bottomSheetState.expand()
    } else {
        bottomSheetScaffoldState.bottomSheetState.collapse()
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomSheet(screenContent: @Composable (BottomSheetScaffoldState) -> Unit) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { BottomSheetContent() },
        sheetPeekHeight = minBottomSheetHeight
    ) {
        screenContent(bottomSheetScaffoldState)
    }
}

@Composable
fun BottomSheetContent() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxBottomSheetHeight)
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color = MaterialTheme.colors.primary)
            .padding(top = 6.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .width(width = maxWidth / 4)
                .background(color = MaterialTheme.colors.secondary)
        )
    }
}