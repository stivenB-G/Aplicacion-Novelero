package com.example.appnovelero.dominio.model


data class Payment(
    val id: String = "",
    val tipo: String = "Tarjeta",
    val numero_enmascarado: String = "**** **** **** 0000",
    val es_predeterminado: Boolean = false,
    val icono_res_id: Int = 0
)
