package com.example.appnovelero.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.appnovelero.R
import com.example.appnovelero.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        // Buscamos los componentes por su ID
        val btnIniciarSesion = findViewById<Button>(R.id.btn_iniciar_sesion)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val tvIrRegistro = findViewById<TextView>(R.id.tv_ir_registro)

        // Acción al hacer clic en "Iniciar Sesión"
        btnIniciarSesion.setOnClickListener {
            // Simulamos el inicio de sesión exitoso navegando a la pantalla principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Acción al hacer clic en "¿Olvidaste tu contraseña?"
        tvForgotPassword.setOnClickListener {
            // Nota: Para que findNavController funcione, LoginActivity debe tener un NavHostFragment
            // O esta navegación debería ocurrir dentro de una actividad que contenga el nav_graph.
            // Por ahora, implementamos según lo solicitado:
            try {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.forgotPasswordFragment)
            } catch (e: Exception) {
                // Fallback si no hay NavController (LoginActivity es una Activity independiente)
                val intent = Intent(this, RecuperarContrasenaActivity::class.java)
                startActivity(intent)
            }
        }

        //Comentario
        // Acción al hacer clic en "Regístrate" (Footer)
        tvIrRegistro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
