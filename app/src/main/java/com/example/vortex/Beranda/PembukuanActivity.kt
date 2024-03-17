package com.example.vortex.Beranda

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vortex.R
import com.example.vortex.databinding.ActivityPembukuanBinding

class PembukuanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembukuanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembukuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFloatin.setOnClickListener {
            val intent = Intent(this, TambahPembukuan::class.java)
            startActivity(intent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}