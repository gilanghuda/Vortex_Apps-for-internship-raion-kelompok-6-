package com.example.vortex.Beranda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vortex.R
import com.example.vortex.databinding.ActivityMainBinding
import com.example.vortex.databinding.ActivityTambahPembukuanBinding

class TambahPembukuan : AppCompatActivity() {
    private lateinit var binding: ActivityTambahPembukuanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPembukuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}