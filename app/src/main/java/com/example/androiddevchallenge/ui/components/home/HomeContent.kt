package com.example.androiddevchallenge.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.minBottomSheetHeight
import com.example.androiddevchallenge.ui.theme.gold
import com.example.androiddevchallenge.ui.theme.transparent
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun HomeContent(actionLeft: () -> Unit, actionRight: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = minBottomSheetHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        DateView(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp),
            date = "Today, 15 Dec",
            city = "Surakarta"
        )
        WeatherImage(
            modifier = Modifier.weight(3f),
            actionLeft = actionLeft,
            actionRight = actionRight
        )
        WeatherTitle(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth(),
            text = "Cloudy"
        )
        WeatherDetails(
            modifier = Modifier.weight(0.8f),
            wind = "234",
            temp = "30",
            humidit = "25"
        )
    }
}

@Composable
private fun DateView(modifier: Modifier, date: String, city: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Column {
            Text(
                text = date,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondary
            )
            Text(
                text = city,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )
        }
        Spacer(modifier = Modifier.weight(4f))
        Image(
            painter = painterResource(id = R.drawable.ic_account_box),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(color = gold)
                .padding(4.dp)
        )
    }
}

@Composable
private fun WeatherImage(modifier: Modifier, actionLeft: () -> Unit, actionRight: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(onClick = actionLeft, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.ArrowLeft, contentDescription = "Arrow left")
        }
        Image(
            painter = painterResource(id = R.drawable.ic_cloud),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
            modifier = Modifier
                .aspectRatio(1f)
                .weight(4f)
        )
        IconButton(onClick = actionRight, modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.ArrowRight, contentDescription = "Arrow right")
        }
    }
}

@Composable
private fun WeatherTitle(modifier: Modifier, text: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(transparent, white)))
        )
    }
}

@Composable
private fun WeatherDetails(modifier: Modifier, wind: String, temp: String, humidit: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        DoubleText("Wind", wind)
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .width(2.dp)
                .background(color = MaterialTheme.colors.secondary)
        )
        DoubleText("Temp", "$temp`C")
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                .width(2.dp)
                .background(color = MaterialTheme.colors.secondary)
        )
        DoubleText("Humidit", "$humidit%")
    }
}

@Composable
fun DoubleText(title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )
    }
}