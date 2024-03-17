package com.example.vortex.Beranda

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.example.vortex.R
import com.example.vortex.databinding.ActivityKonsultasiBinding
import com.example.vortex.databinding.SheetKonsultasiBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class KonsultasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKonsultasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonsultasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnTanggalKonsultasi.setOnClickListener {
            showBottomSheet()
        }
        binding.btnBulanKonsultasi.setOnClickListener {
            showBottomSheet()
        }
        binding.btnTahunKonsultasi.setOnClickListener {
            showBottomSheet()
        }
        binding.btnSimpan.setOnClickListener {
            showCustomDialogBox()
        }
        binding.btnJam9.setOnClickListener {
            btnjam9efek()
        }
        binding.btnJam10.setOnClickListener {
            btnjam10efek()
        }
        binding.btnJam13.setOnClickListener {
            btnjam13efek()
        }
    }

    private fun showBottomSheet(){
        val sheetDialog = BottomSheetDialog(this)
        val sheetBinding = SheetKonsultasiBinding.inflate(layoutInflater)
        sheetDialog.apply {
            setContentView(sheetBinding.root)
            show()
        }
        sheetBinding.btnKalender.setOnClickListener{
            sheetDialog.dismiss()
        }
    }
    private fun showCustomDialogBox(){
        val dialog = Dialog(this)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.custom_dialog_konsultasi)
        val roundedBackground: Drawable? = ContextCompat.getDrawable(this, R.drawable.rounded)
        dialog.window?.setBackgroundDrawable(roundedBackground)
        dialog.show()
        val btnYa = dialog.findViewById<Button>(R.id.btn_ya)
        val btnTidak = dialog.findViewById<Button>(R.id.btn_tidak)
        btnYa.setOnClickListener {
            val intent = Intent(this, SplashKonsultasi::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
        btnTidak.setOnClickListener {
            dialog.dismiss()
        }
    }
    fun btnjam9efek(){
        binding.btnJam9.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
        binding.btnJam9.setTextColor(ContextCompat.getColorStateList(this, R.color.black))

        binding.btnJam10.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam10.setTextColor(ContextCompat.getColorStateList(this, R.color.white))

        binding.btnJam13.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam13.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
    }
    fun btnjam10efek(){
        binding.btnJam9.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam9.setTextColor(ContextCompat.getColorStateList(this, R.color.white))

        binding.btnJam10.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
        binding.btnJam10.setTextColor(ContextCompat.getColorStateList(this, R.color.black))

        binding.btnJam13.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam13.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
    }
    fun btnjam13efek(){
        binding.btnJam9.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam9.setTextColor(ContextCompat.getColorStateList(this, R.color.white))

        binding.btnJam10.backgroundTintList = ContextCompat.getColorStateList(this, R.color.black)
        binding.btnJam10.setTextColor(ContextCompat.getColorStateList(this, R.color.white))

        binding.btnJam13.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
        binding.btnJam13.setTextColor(ContextCompat.getColorStateList(this, R.color.black))
    }
}