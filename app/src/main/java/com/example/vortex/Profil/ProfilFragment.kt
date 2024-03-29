package com.example.vortex.Profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vortex.Navigation.NavProfile
import com.example.vortex.databinding.FragmentProfilBinding


class ProfilFragment : Fragment() {
  private lateinit var binding: FragmentProfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilBinding.inflate(inflater, container, false)
        binding.profilcomposeView.setContent {
            NavProfile()
        }
        return binding.root
    }


}