package com.example.androiddevchallenge.ui.components.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheet(screenContent: @Composable () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetContent(
                action = {
                    coroutineScope.launch {
                        changeBottomSheetState(bottomSheetScaffoldState)
                    }
                },
                bottomSheetScaffoldState = bottomSheetScaffoldState
            )
        },
        sheetPeekHeight = minBottomSheetHeight
    ) {
        screenContent()
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
fun BottomSheetContent(action: () -> Unit, bottomSheetScaffoldState: BottomSheetScaffoldState) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxBottomSheetHeight)
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(color = MaterialTheme.colors.primary)
            .padding(top = 6.dp)
            .animateContentSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        if (bottomSheetScaffoldState.bottomSheetState.isExpanded)
            MaxBottomSheetContent()
        else
            MinBottomSheetContent(action = action)
    }
}