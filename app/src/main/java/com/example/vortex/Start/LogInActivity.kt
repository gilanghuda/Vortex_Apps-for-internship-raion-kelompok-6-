package com.example.vortex.Start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.example.vortex.Navigation.NavLogin

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val composeView = ComposeView(this).apply {
            setContent {
                NavLogin()
            }
        }
        setContentView(composeView)
    }

}