package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.HOME
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.SEARCH
import com.example.androiddevchallenge.SETTINGS
import java.util.Locale

@Composable
fun BottomBar(navController: NavHostController) {
    Surface(
        elevation = 8.dp,
        color = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            NavigationIcon(
                title = stringResource(R.string.home),
                modifier = Modifier.clickable { navController.navigate(HOME) }
            )
            NavigationIcon(
                title = stringResource(R.string.search),
                modifier = Modifier.clickable { navController.navigate(SEARCH) }
            )
            NavigationIcon(
                title = stringResource(R.string.settings),
                modifier = Modifier.clickable { navController.navigate(SETTINGS) }
            )
        }
    }
}

@Composable
fun NavigationIcon(title: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
            contentDescription = stringResource(R.string.home),
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = title.toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onBackground
        )
    }
}