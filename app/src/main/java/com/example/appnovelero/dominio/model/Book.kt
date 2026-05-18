package com.example.appnovelero.dominio.model

import kotlinx.serialization.Serializable

/**
 * Representa una novela vinculada a la base de datos de Supabase.
 */
@Serializable
data class Book(
    val id: String = "",              
    val titulo: String = "",
    val autor_id: String? = null,     // Cambiamos a autor_id para coincidir con la BD
    val sinopsis: String = "",
    val genero: String = "",
    val precio: Double = 0.0,
    val portada_url: String = "",     
    val vistas: Int = 0,
    val capitulos: Int = 0,
    val rating: Double = 0.0,
    val volumen: Int = 1,
    val creado_en: String = ""
)
