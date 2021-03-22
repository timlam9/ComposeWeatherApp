package com.example.androiddevchallenge.ui.components.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.whiteTransparent

@Composable
fun WeatherColumnCard(@DrawableRes icon: Int, time: String, temp: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = whiteTransparent,
        modifier = Modifier.wrapContentSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(painter = painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = time,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.surface
            )
            Text(
                text = "$temp'C",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.surface
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WeatherColumnCard(R.drawable.ic_cloud, "17:00", "40")
    }
}