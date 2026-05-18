package com.example.appnovelero.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appnovelero.R
import com.example.appnovelero.data.repository.AuthRepository
import com.example.appnovelero.ui.main.MainActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val authRepository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Verificamos si ya hay una sesión activa para saltar el login
        if (authRepository.isUserLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_inicio_sesion)

        val etCorreo = findViewById<EditText>(R.id.et_correo)
        val etContrasena = findViewById<EditText>(R.id.et_contrasena)
        val btnIniciarSesion = findViewById<Button>(R.id.btn_iniciar_sesion)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val tvIrRegistro = findViewById<TextView>(R.id.tv_ir_registro)

        btnIniciarSesion.setOnClickListener {
            val email = etCorreo.text.toString().trim()
            val password = etContrasena.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val error = authRepository.login(email, password)
                if (error == null) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Error: $error", Toast.LENGTH_LONG).show()
                }
            }
        }

        tvForgotPassword.setOnClickListener {
            val intent = Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(intent)
        }

        tvIrRegistro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
