package com.example.appnovelero.dominio.model

data class Notification(
    val id: String = "",
    val mensaje: String = "",
    val fecha: String = "",
    val leida: Boolean = false,
    val bookId: String = ""
)
