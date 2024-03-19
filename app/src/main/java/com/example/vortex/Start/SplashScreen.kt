package com.example.vortex.Start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vortex.R

@Preview
@Composable
fun SplashScreen() {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_vortextext),
            contentDescription = null,
            modifier = Modifier.size(height = 80.dp, width = 210.dp))
    }
}

@Preview
@Composable
fun SplashScreenPrev() {
    SplashScreen()
}
