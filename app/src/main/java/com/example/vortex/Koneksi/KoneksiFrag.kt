package com.example.vortex.Koneksi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vortex.databinding.FragmentKoneksiBinding

class KoneksiFrag : Fragment() {
    private lateinit var binding: FragmentKoneksiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKoneksiBinding.inflate(inflater, container, false)
        binding.koneksicomposeView.setContent {
            KoneksiScreen()
        }
        return binding.root
    }


}