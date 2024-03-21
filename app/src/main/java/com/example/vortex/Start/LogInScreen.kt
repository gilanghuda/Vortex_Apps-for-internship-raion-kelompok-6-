package com.example.vortex.Start

import android.content.Intent
import android.widget.Toast
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
import com.example.vortex.Navigation.Screen
import com.example.vortex.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LogInScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.fillMaxSize().padding(25.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            TextComponent(textValue = "Masuk", size = 25.sp )
            Spacer(modifier = Modifier.height(22.dp))
            TextComponent(textValue = "Selamat Datang Kembali di Vortex !", size = 16.sp)
            Spacer(modifier = Modifier.height(50.dp))
            NormalTextField(
                icon = painterResource(id = R.drawable.ic_email),
                labelValue = "Email",
                text = email,
                onValueChange = { email = it})
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextField(
                icon = painterResource(id = R.drawable.ic_profil),
                labelValue = "Kata Sandi",
                text = password,
                onValueChange = { password = it})
            Spacer(modifier = Modifier.height(55.dp))
            ButtonSign(textValue = "Masuk", onClick = {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            context.startActivity(Intent(context, MainActivity::class.java))

                        } else {
                            Toast.makeText(context, "Login failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            })
            SingleClickableTextComponent(clickTextValue = "Lupa kata sandi?")
            Spacer(modifier = Modifier.height(22.dp))
            MultiClickableTextComponent(
                initialTextValue = "Belum memiliki akun? ",
                clickTextValue = "Daftar",
                onClick = { navController.navigate(Screen.ChooseRoleRoute.route) }
            )
        }
    }
}



//@Preview
//@Composable
//fun LogInPrev() {
//    LogInScreen()
//}