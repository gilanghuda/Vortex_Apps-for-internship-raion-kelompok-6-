package com.example.vortex.Beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vortex.R
import com.example.vortex.databinding.ActivityDetailRowBerandaBinding

class DetailRowBeranda : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRowBerandaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRowBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}