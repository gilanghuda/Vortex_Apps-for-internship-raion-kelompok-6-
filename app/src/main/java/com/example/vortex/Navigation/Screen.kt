package com.example.vortex.Navigation

sealed class Screen (val route: String){
    object LoginRoute : Screen(route = "Login")
    object SignInRoute : Screen(route = "SignIn")
    object KoneksiRoute : Screen(route = "Koneksi")
    object DetailKoneksiRoute : Screen(route = "DetailKoneksi")
    object AuthRoute : Screen(route = "Auth")
    object ChooseRoleRoute : Screen(route = "ChooseRole")


    object ProfileRoute : Screen(route = "Profile")
    object EditProfileRoute : Screen(route = "EditProfile")

}