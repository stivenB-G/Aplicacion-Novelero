package com.example.appnovelero.data.repository

import com.example.appnovelero.data.remote.SupabaseClient
import com.example.appnovelero.dominio.model.Book
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository {

    private val postgrest = SupabaseClient.client.postgrest

    /**
     * Trae la lista completa de libros desde la tabla 'libros' en Supabase.
     */
    suspend fun getAllBooks(): List<Book> = withContext(Dispatchers.IO) {
        try {
            val response = postgrest["libros"].select()
            response.decodeList<Book>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
