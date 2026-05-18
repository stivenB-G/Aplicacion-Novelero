package com.example.appnovelero.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R
import com.example.appnovelero.data.repository.AuthRepository
import com.example.appnovelero.ui.auth.LoginActivity
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private val authRepository = AuthRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        val adminCard = view.findViewById<CardView>(R.id.card_admin_panel)
        val btnPremium = view.findViewById<CardView>(R.id.card_mejorar_premium)
        val btnLogout = view.findViewById<Button>(R.id.btn_cerrar_sesion)

        adminCard.setOnClickListener {
            findNavController().navigate(R.id.navigation_admin_dashboard)
        }

        btnPremium.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_perfil_to_navigation_payment)
        }

        btnLogout.setOnClickListener {
            lifecycleScope.launch {
                authRepository.logout()
                // Redirigir al Login y cerrar la MainActivity
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }

        return view
    }
}
