package com.example.vortex.Start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vortex.R

@Composable
fun SignInScreen(navController: NavController) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var perusahaan by remember { mutableStateOf("") }
    var lokasi by remember { mutableStateOf("") }
    var nomorHP by remember { mutableStateOf("") }
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            TextComponent(textValue = "Daftar", 25.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextComponent(textValue = "Selamat Datang di Vortex !", 16.sp)
            Spacer(modifier = Modifier.height(68.dp))
            NormalTextField(icon = painterResource(
                id = R.drawable.ic_profilesign), 
                labelValue = "Nama Lengkap",
                text = nama,
                onValueChange = {nama = it})
            Spacer(modifier = Modifier.height(14.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_building),
                labelValue = "Nama Perusahaan",
                text = perusahaan,
                onValueChange = {perusahaan = it})
            Spacer(modifier = Modifier.height(14.dp))
            DropdownMenuBox()
            Spacer(modifier = Modifier.height(14.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_lokasi),
                labelValue = "Lokasi",
                text = lokasi,
                onValueChange = {lokasi = it})
            Spacer(modifier = Modifier.height(14.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_email),
                labelValue = "Email",
                text = email,
                onValueChange = {email = it})
            Spacer(modifier = Modifier.height(14.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_telp), 
                labelValue = "Nomor Telepon",
                text = nomorHP,
                onValueChange = {nomorHP=it})
            Spacer(modifier = Modifier.height(46.dp))
            PasswordTextField(
                text = password,
                onValueChange = {password=it},
                icon = painterResource(id = R.drawable.ic_profil
            ) , labelValue = "Password")
            ButtonSign(textValue = "Daftar", onClick = {})
        }
    }
}

//@Preview
//@Composable
//fun PreviewSignIn() {
//    SignInScreen()
//}