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

class RegisterActivity : AppCompatActivity() {

    private val authRepository = AuthRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val etUsuario = findViewById<EditText>(R.id.et_nombre_usuario)
        val etCorreo = findViewById<EditText>(R.id.et_correo_registro)
        val etContrasena = findViewById<EditText>(R.id.et_contrasena_registro)
        val btnCrearCuenta = findViewById<Button>(R.id.btn_crear_cuenta)
        val tvIrLogin = findViewById<TextView>(R.id.tv_ir_login)

        btnCrearCuenta.setOnClickListener {
            val username = etUsuario.text.toString().trim()
            val email = etCorreo.text.toString().trim()
            val password = etContrasena.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val error = authRepository.register(email, password)
                if (error == null) {
                    Toast.makeText(this@RegisterActivity, "Cuenta creada exitosamente. ¡Bienvenido!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@RegisterActivity, "Error: $error", Toast.LENGTH_LONG).show()
                    android.util.Log.e("SupabaseAuth", "Error al registrar: $error")
                }
            }
        }

        tvIrLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
