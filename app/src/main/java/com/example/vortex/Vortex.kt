package com.example.vortex

import android.app.Application
import com.google.firebase.FirebaseApp

class Vortex : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
