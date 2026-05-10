package com.example.appnovelero.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_perfil,
            container,
            false
        )

        val adminCard = view.findViewById<CardView>(
            R.id.card_admin_panel
        )

        adminCard.setOnClickListener {

            findNavController().navigate(
                R.id.navigation_admin_dashboard
            )

        }

        return view
    }
}
