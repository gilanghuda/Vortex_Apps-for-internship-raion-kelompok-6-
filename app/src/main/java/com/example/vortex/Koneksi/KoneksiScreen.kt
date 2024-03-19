package com.example.vortex.Koneksi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun KoneksiScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Koneksi") {
        composable("Koneksi") { Koneksi(navController) }
//        composable("detail") { DetailScreen(navController) }
    }
}

