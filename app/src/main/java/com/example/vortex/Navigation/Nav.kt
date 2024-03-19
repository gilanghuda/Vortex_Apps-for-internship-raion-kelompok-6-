package com.example.vortex.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vortex.Koneksi.DetailKoneksi
import com.example.vortex.Koneksi.Koneksi
import com.example.vortex.Start.LogInScreen
import com.example.vortex.Start.SignInScreen

@Composable
fun NavLogin() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AuthRoute.route) {
        composable(route= Screen.KoneksiRoute.route){
            LogInScreen(navController = navController)
        }
        composable(route= Screen.SignInRoute.route){
            SignInScreen(navController = navController)
        }
    }
}

@Composable
fun NavKoneksi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.KoneksiRoute.route) {
        composable(route= Screen.KoneksiRoute.route){
            Koneksi(navController = navController)
        }
        composable(route= Screen.KoneksiRoute.route){
            DetailKoneksi(navController = navController)
        }
    }
}