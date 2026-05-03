package com.example.appnovelero.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appnovelero.R

class RecuperarContrasenaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contrasena)

        // Buscamos los componentes por su ID
        val btnEnviar = findViewById<Button>(R.id.btn_enviar_instrucciones)
        val tvVolverLogin = findViewById<TextView>(R.id.tv_volver_login)

        // Acción al hacer clic en "Enviar instrucciones"
        btnEnviar.setOnClickListener {

            finish()
        }

        // Acción al hacer clic en "Volver al Inicio de Sesión"
        tvVolverLogin.setOnClickListener {
            finish()
        }
    }
}
