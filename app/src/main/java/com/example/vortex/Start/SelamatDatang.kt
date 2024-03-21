package com.example.vortex.Start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vortex.R


@Composable
fun SelamatDatang(
    onLoginSelected: () -> Unit,
    onSignUpSelected: () -> Unit
) {
    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg_start),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(470.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(450.dp)
                .padding(25.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Blue)
                .clip(RoundedCornerShape(topStart = 1f, topEnd = 1f))
        ){
            Column {
                TextComponent(
                    textValue = "Selamat Datang!",
                    size = 25.sp)
                Spacer(modifier = Modifier.height(37.dp))
                TextComponent(
                    textValue = "Selamat datang di aplikasi bisnis kami! Temukan layanan unggulan untuk efisiensi bisnis Anda. Mari jalin koneksi baru sekarang!",
                    size = 12.sp)
                ButtonSign(textValue =  "Masuk") {
                    onLoginSelected()
                }
                ButtonSign(textValue = "Daftar") {
                    onSignUpSelected()
                }
            }
        }
    }
}