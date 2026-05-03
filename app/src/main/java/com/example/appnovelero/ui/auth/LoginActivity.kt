package com.example.appnovelero.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appnovelero.R
import com.example.appnovelero.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        // Buscamos los componentes por su ID
        val btnIniciarSesion = findViewById<Button>(R.id.btn_iniciar_sesion)
        val tvOlvideContrasena = findViewById<TextView>(R.id.tv_olvide_contrasena)
        val tvIrRegistro = findViewById<TextView>(R.id.tv_ir_registro)

        // Acción al hacer clic en "Iniciar Sesión"
        btnIniciarSesion.setOnClickListener {
            // Simulamos el inicio de sesión exitoso navegando a la pantalla principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Acción al hacer clic en "¿Olvidaste tu contraseña?"
        tvOlvideContrasena.setOnClickListener {
            val intent = Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(intent)
        }

        // Acción al hacer clic en "Regístrate" (Footer)
        tvIrRegistro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
