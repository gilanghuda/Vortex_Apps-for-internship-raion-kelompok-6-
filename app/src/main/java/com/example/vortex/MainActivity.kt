package com.example.vortex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.vortex.Beranda.BerandaFragment
import com.example.vortex.Koneksi.KoneksiFrag
import com.example.vortex.Profil.ProfilFragment
import com.example.vortex.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BerandaFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.bn_beranda -> replaceFragment(BerandaFragment())
                R.id.bn_koneksi -> replaceFragment(KoneksiFrag())
                R.id.bn_profil -> replaceFragment(ProfilFragment())

                else ->{



                }

            }

            true

        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainact,fragment)
        fragmentTransaction.commit()


    }
}