package com.example.vortex.Beranda

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vortex.R
import com.example.vortex.databinding.ActivityKonsultasiBinding
import com.example.vortex.databinding.ActivityKonsultasiKonfirmasiBinding

class KonsultasiKonfirmasi : AppCompatActivity() {
    private lateinit var binding: ActivityKonsultasiKonfirmasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonsultasiKonfirmasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLihatInvoice.setOnClickListener {
            val intent = Intent(this, InvoiceKonsultasi::class.java)
            startActivity(intent)
            finish()
        }
    }
}