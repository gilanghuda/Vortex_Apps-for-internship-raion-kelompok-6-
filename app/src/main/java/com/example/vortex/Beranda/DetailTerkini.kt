package com.example.vortex.Beranda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vortex.R
import com.example.vortex.databinding.ActivityDetailTerkiniBinding


class DetailTerkini : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTerkiniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTerkiniBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}