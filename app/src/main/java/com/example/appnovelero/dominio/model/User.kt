package com.example.appnovelero.dominio.model


data class User(
    val id: String = "",
    val nombre: String = "",
    val email: String = "",
    val rol: String = "Free", // Free, Premium, Admin, Moderador
    val avatar_url: String = "",
    val libros_leidos: Int = 0,
    val libros_publicados: Int = 0,
    val creado_en: String = ""
)
