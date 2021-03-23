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
package com.example.androiddevchallenge.presentation.ui.components.home.bottomsheet

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
import com.example.androiddevchallenge.presentation.activity.MainViewModel
import com.example.androiddevchallenge.presentation.ui.maxBottomSheetHeight
import com.example.androiddevchallenge.presentation.ui.minBottomSheetHeight
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheet(viewModel: MainViewModel, screenContent: @Composable () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetContent(
                viewModel = viewModel,
                bottomSheetScaffoldState = bottomSheetScaffoldState,
                action = {
                    coroutineScope.launch {
                        changeBottomSheetState(bottomSheetScaffoldState)
                    }
                }
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
fun BottomSheetContent(
    viewModel: MainViewModel,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    action: () -> Unit,
) {
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
            MaxBottomSheetContent(data = viewModel.dailyData)
        else
            MinBottomSheetContent(data = viewModel.hourlyData, action = action)
    }
}
