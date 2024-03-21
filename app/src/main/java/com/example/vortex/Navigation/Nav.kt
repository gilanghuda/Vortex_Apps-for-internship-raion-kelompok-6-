package com.example.vortex.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vortex.Koneksi.Koneksi
import com.example.vortex.Profil.EditProfile
import com.example.vortex.Profil.ProfileScreen
import com.example.vortex.Start.ChooseRole
import com.example.vortex.Start.LogInScreen
import com.example.vortex.Start.SelamatDatang
import com.example.vortex.Start.SignInScreen

@Composable
fun NavLogin() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AuthRoute.route) {
        composable(route=Screen.AuthRoute.route){
            SelamatDatang(
                onLoginSelected = { navController.navigate(Screen.LoginRoute.route) },
                onSignUpSelected = { navController.navigate(Screen.ChooseRoleRoute.route) }
            )
        }
        composable(route= Screen.LoginRoute.route){
            LogInScreen(navController = navController, )
        }
        composable(route= Screen.ChooseRoleRoute.route){
            ChooseRole(navController = navController)
        }
        composable(
            route = "${Screen.SignInRoute.route}/{role}",
            arguments = listOf(navArgument("role") { type = NavType.StringType })
        ) { backStackEntry ->
            SignInScreen(
                navController = navController,
                role = backStackEntry.arguments?.getString("role") ?: ""
            )
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
        composable(route= Screen.DetailKoneksiRoute.route){
//            DetailKoneksi(navController = navController)
        }
    }
}

@Composable
fun NavProfile() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ProfileRoute.route) {
        composable(route= Screen.ProfileRoute.route){
            ProfileScreen(navController = navController)
        }
        composable(route= Screen.EditProfileRoute.route){
            EditProfile(navController = navController)
        }
    }
}