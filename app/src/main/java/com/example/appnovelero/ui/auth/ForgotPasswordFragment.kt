package com.example.appnovelero.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.appnovelero.R
import com.example.appnovelero.data.repository.AuthRepository
import kotlinx.coroutines.launch

class ForgotPasswordFragment : Fragment() {

    private val authRepository = AuthRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recuperar_contrasena, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val etCorreo = view.findViewById<EditText>(R.id.et_correo_recuperar_frag)
        val btnEnviar = view.findViewById<Button>(R.id.btn_enviar_instrucciones_frag)
        val tvVolver = view.findViewById<View>(R.id.tv_volver_login_frag)

        btnEnviar.setOnClickListener {
            val email = etCorreo.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(context, "Ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val success = authRepository.sendResetPasswordEmail(email)
                if (success) {
                    Toast.makeText(context, "Se han enviado instrucciones a tu correo", Toast.LENGTH_LONG).show()
                    activity?.onBackPressedDispatcher?.onBackPressed()
                } else {
                    Toast.makeText(context, "Error al enviar el correo. Verifica los datos.", Toast.LENGTH_LONG).show()
                }
            }
        }

        tvVolver.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }
}
