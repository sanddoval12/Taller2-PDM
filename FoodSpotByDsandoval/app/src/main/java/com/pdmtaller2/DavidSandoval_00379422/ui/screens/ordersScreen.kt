package com.pdmtaller2.DavidSandoval_00379422.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmtaller2.DavidSandoval_00379422.ui.componentes.ordenesCard
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel
import com.pdmtaller2.DavidSandoval_00379422.ui.theme.MoradoFuturoPrimario
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField

@Composable
fun ordersScreen(viewModel: foodSpotViewModel = viewModel()) {
    val carrito = viewModel.carrito.collectAsState().value
    var filtro by remember { mutableStateOf("") }

    val ordenesFiltradas = if (filtro.isBlank()) carrito else viewModel.buscarOrdenes(filtro)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Pantalla de órdenes",
            style = MaterialTheme.typography.headlineMedium,
            color = MoradoFuturoPrimario
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (carrito.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Tu carrito está vacío.",
                    color = MoradoFuturoPrimario,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        } else {
            OutlinedTextField(
                value = filtro,
                onValueChange = { filtro = it },
                label = { Text("Buscar orden") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            ordenesFiltradas.forEach { orden ->
                ordenesCard(orden)
            }
        }
    }
}
