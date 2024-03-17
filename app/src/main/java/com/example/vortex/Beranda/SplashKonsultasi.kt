package com.example.vortex.Beranda

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vortex.R

class SplashKonsultasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_konsultasi)
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, KonsultasiKonfirmasi::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}