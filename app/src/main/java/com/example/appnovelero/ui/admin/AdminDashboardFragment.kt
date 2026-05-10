package com.example.appnovelero.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R

class AdminDashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_dashboard, container, false)

        val btnGestionarUsuarios = view.findViewById<Button>(R.id.btn_gestionar_usuarios)
        btnGestionarUsuarios.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_admin_dashboard_to_navigation_admin_usuarios)
        }

        val btnGestionarLibros = view.findViewById<Button>(R.id.btn_gestionar_libros)
        btnGestionarLibros.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_admin_dashboard_to_navigation_admin_libros)
        }

        val btnVerReportes = view.findViewById<Button>(R.id.btn_ver_reportes)
        btnVerReportes.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_admin_dashboard_to_navigation_admin_ventas)
        }

        return view
    }
}
