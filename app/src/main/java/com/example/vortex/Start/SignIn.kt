package com.example.vortex.Start

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vortex.MainActivity
import com.example.vortex.R
import com.example.vortex.data.FirebaseAuthManager

@Composable
fun SignInScreen(navController: NavController, role: String) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var perusahaan by remember { mutableStateOf("") }
    var lokasi by remember { mutableStateOf("") }
    var nomorHP by remember { mutableStateOf("") }
    var selectedBidang by remember { mutableStateOf("") }
    val context = LocalContext.current
    val firebaseAuthManager = FirebaseAuthManager(context)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(25.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            TextComponent(textValue = "Daftar", 25.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextComponent(textValue = "Selamat Datang di Vortex !", 16.sp)
            Spacer(modifier = Modifier.height(68.dp))
            NormalTextField(icon = painterResource(
                id = R.drawable.ic_profilesign
            ),
                labelValue = "Nama Lengkap",
                text = nama,
                onValueChange = { nama = it })
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_building),
                labelValue = "Nama Perusahaan",
                text = perusahaan,
                onValueChange = { perusahaan = it })
            Spacer(modifier = Modifier.height(10.dp))
            DropdownMenuBox(
                selectedBidang = selectedBidang,
                onSelectedBidangChange = { selectedBidang = it })
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_lokasi),
                labelValue = "Lokasi",
                text = lokasi,
                onValueChange = { lokasi = it })
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_email),
                labelValue = "Email",
                text = email,
                onValueChange = { email = it })
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_telp),
                labelValue = "Nomor Telepon",
                text = nomorHP,
                onValueChange = { nomorHP = it })
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(
                text = password,
                onValueChange = { password = it },
                icon = painterResource(
                    id = R.drawable.ic_profil
                ), labelValue = "Password"
            )
            ButtonSign(textValue = "Daftar", onClick = {
                val userDetails = hashMapOf(
                    "nama" to nama,
                    "email" to email,
                    "perusahaan" to perusahaan,
                    "lokasi" to lokasi,
                    "nomorHP" to nomorHP,
                    "role" to role,
                    "bidang" to selectedBidang
                )

                firebaseAuthManager.createUser(email, password, userDetails, onSuccess = {
                    Log.d("SignInScreen", "Account creation successful")
                    val intent = Intent(context, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    Log.d("SignInScreen", "Navigating to MainActivity")
                    context.startActivity(intent)

                }, onFailure = { errorMessage ->
                    Log.e("SignInScreen", "Error creating user: $errorMessage")
                    // Consider showing a Toast or dialog here to inform the user
                })
            })
        }
    }
}
