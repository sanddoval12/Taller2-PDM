package com.pdmtaller2.DavidSandoval_00379422.data.modelo

data class Restaurante(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val imagenUrl: String,
    val categoria: String,
    val menu: List<Plato>
)
