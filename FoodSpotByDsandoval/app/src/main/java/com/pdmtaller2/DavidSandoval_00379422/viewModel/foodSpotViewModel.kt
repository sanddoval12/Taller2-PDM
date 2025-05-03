package com.pdmtaller2.DavidSandoval_00379422.viewModel

import androidx.lifecycle.ViewModel
import com.pdmtaller2.DavidSandoval_00379422.data.modelo.*
import com.pdmtaller2.DavidSandoval_00379422.data.repositorio.listaRestaurantes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class foodSpotViewModel : ViewModel() {

    private val _restaurantes = MutableStateFlow(listaRestaurantes.restaurantes)
    val restaurantes: StateFlow<List<Restaurante>> = _restaurantes

    private val _busqueda = MutableStateFlow("")
    val busqueda: StateFlow<String> = _busqueda

    private val _carrito = MutableStateFlow<List<Orden>>(emptyList())
    val carrito: StateFlow<List<Orden>> = _carrito


    fun agregarAlCarrito(plato: Plato, restaurante: Restaurante) {
        val orden = Orden(plato, restaurante.nombre, restaurante.categoria)
        _carrito.value = _carrito.value + orden
    }


    fun actualizarBusqueda(nueva: String) {
        _busqueda.value = nueva
    }

    fun filtrarMenu(restaurante: Restaurante, query: String): List<Plato> {
        return restaurante.menu.filter {
            it.nombre.contains(query, ignoreCase = true)
        }
    }

    fun buscarRestaurantes(query: String): List<Restaurante> {
        return _restaurantes.value.filter { restaurante ->
            restaurante.nombre.contains(query, ignoreCase = true)
                    || restaurante.categoria.contains(query, ignoreCase = true)
                    || restaurante.menu.any { it.nombre.contains(query, ignoreCase = true) }
        }
    }

    fun obtenerPorId(id: Int): Restaurante? {
        return _restaurantes.value.find { it.id == id }
    }

    fun buscarOrdenes(query: String): List<Orden> {
        return carrito.value.filter {
            it.plato.nombre.contains(query, ignoreCase = true) ||
                    it.restaurante.contains(query, ignoreCase = true) ||
                    it.categoria.contains(query, ignoreCase = true)
        }
    }
}