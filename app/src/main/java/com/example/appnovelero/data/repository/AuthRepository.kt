package com.example.appnovelero.data.repository

import com.example.appnovelero.data.remote.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

/**
 * Repositorio para gestionar la autenticación con Supabase Auth.
 */
class AuthRepository {

    private val auth = SupabaseClient.client.auth

    /**
     * Inicia sesión con correo y contraseña.
     * Retorna el mensaje de error si falla, o null si es exitoso.
     */
    suspend fun login(email: String, password: String): String? {
        return try {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            null
        } catch (e: Exception) {
            e.message ?: "Error desconocido al iniciar sesión"
        }
    }

    /**
     * Registra un nuevo usuario con correo y contraseña.
     * Retorna el mensaje de error si falla, o null si es exitoso.
     */
    suspend fun register(email: String, password: String): String? {
        return try {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            null
        } catch (e: Exception) {
            e.message ?: "Error desconocido al crear la cuenta"
        }
    }

    /**
     * Envía un correo para restablecer la contraseña.
     */
    suspend fun sendResetPasswordEmail(email: String): Boolean {
        return try {
            auth.resetPasswordForEmail(email)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * Cierra la sesión del usuario actual.
     */
    suspend fun logout() {
        try {
            auth.signOut()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Verifica si hay un usuario con sesión activa.
     */
    fun isUserLoggedIn(): Boolean {
        return try {
            auth.currentSessionOrNull() != null
        } catch (e: Exception) {
            false
        }
    }
}
