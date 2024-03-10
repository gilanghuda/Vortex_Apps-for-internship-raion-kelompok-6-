package com.example.vortex.Beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.vortex.R
import com.example.vortex.databinding.ActivityKonsultasiBinding

class KonsultasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKonsultasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonsultasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}