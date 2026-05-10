package com.example.appnovelero.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appnovelero.R

class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recuperar_contrasena, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        view.findViewById<View>(R.id.tv_volver_login_frag).setOnClickListener {
            // Regresa a la pantalla anterior
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }
}
