package com.pdmtaller2.DavidSandoval_00379422.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import com.pdmtaller2.DavidSandoval_00379422.ui.componentes.restauranteCard
import com.pdmtaller2.DavidSandoval_00379422.ui.theme.MoradoFuturoPrimario
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel

@Composable
fun busquedaScreen(viewModel: foodSpotViewModel, navController: NavController) {
    val busqueda by viewModel.busqueda.collectAsState()
    val resultados = viewModel.buscarRestaurantes(busqueda)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(
            "Pantalla de búsqueda",
            style = MaterialTheme.typography.headlineMedium,
            color = MoradoFuturoPrimario
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = busqueda,
            onValueChange = { viewModel.actualizarBusqueda(it) },
            label = { Text("Buscar restaurantes o platillos") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(resultados) { restaurante ->
                restauranteCard(restaurante) {
                    navController.navigate("menu/${restaurante.id}")
                }
            }
        }
    }
}