package com.example.appnovelero.dominio.model


data class CartItem(
    val id: String = "",
    val libro: Book,
    val fecha_agregado: String = ""
)
