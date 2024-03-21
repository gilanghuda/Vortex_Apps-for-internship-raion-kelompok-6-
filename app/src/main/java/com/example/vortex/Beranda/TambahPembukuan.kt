package com.example.vortex.Beranda

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vortex.R
import com.example.vortex.databinding.ActivityMainBinding
import com.example.vortex.databinding.ActivityTambahPembukuanBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class TambahPembukuan : AppCompatActivity() {
    private lateinit var binding: ActivityTambahPembukuanBinding
    private lateinit var caraPembayaran: String
    private lateinit var auth: FirebaseAuth
    private lateinit var authId: String
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPembukuanBinding.inflate(layoutInflater)
        setContentView(binding.root)

                auth = FirebaseAuth.getInstance()
        authId = auth.currentUser!!.uid
        database = Firebase.database.reference.child("Pembukuan").child(authId)

        val pembukuanList: MutableList<RowPembukuanItem> =
            intent.getSerializableExtra("pembukuanList") as? MutableList<RowPembukuanItem>
                ?: mutableListOf()

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSimpan.setOnClickListener {
            val data = RowPembukuanItem(binding.etKategori.text.toString(), caraPembayaran, binding.etTotal.text.toString())
            savePembukuan(data)
            pembukuanList.add(data)
        }
        caraPembayaran = "Tunai"
        binding.btnTunai.setOnClickListener {
            caraPembayaran = "Tunai"
        }
        binding.btnKartu.setOnClickListener {
            caraPembayaran = "Kartu"
        }
        binding.btnBank.setOnClickListener {
            caraPembayaran = "Bank"
        }
    }
    fun  savePembukuan(pembukuanList: RowPembukuanItem) {

        database.push().setValue(pembukuanList).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}