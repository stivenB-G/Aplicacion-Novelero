package com.example.appnovelero.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appnovelero.R
import com.example.appnovelero.ui.main.MainActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Buscamos los componentes por su ID
        val btnCrearCuenta = findViewById<Button>(R.id.btn_crear_cuenta)
        val tvIrLogin = findViewById<TextView>(R.id.tv_ir_login)

        // Acción al hacer clic en "Crear cuenta"
        btnCrearCuenta.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Acción al hacer clic en "Iniciar Sesión" (Footer)
        tvIrLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
