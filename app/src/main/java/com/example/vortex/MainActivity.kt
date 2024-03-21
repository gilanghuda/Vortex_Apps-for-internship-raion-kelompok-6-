package com.example.vortex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.vortex.Beranda.BerandaFragment
import com.example.vortex.Koneksi.KoneksiFrag
import com.example.vortex.Profil.ProfilFragment
import com.example.vortex.Start.LoginActivity
import com.example.vortex.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (FirebaseAuth.getInstance().currentUser == null) {
            // User is not logged in, redirect to login screen
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Finish MainActivity to remove it from the back stack
            return
        }


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
