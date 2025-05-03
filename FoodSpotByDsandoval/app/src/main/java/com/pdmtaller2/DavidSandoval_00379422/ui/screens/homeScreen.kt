package com.pdmtaller2.DavidSandoval_00379422.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.DavidSandoval_00379422.ui.componentes.restauranteCard
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel

@Composable
fun homeScreen(viewModel: foodSpotViewModel, navController: NavController) {
    val restaurantes = viewModel.restaurantes.collectAsState().value
    val categorias = restaurantes.groupBy { it.categoria }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Food Spot",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFF9C27B0)
                )
                Text(
                    text = "Tu comida favorita a un solo clic",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFCE93D8)
                )
            }
        }
        categorias.forEach { (categoria, listaRestaurantes) ->
            item {
                Column {
                    Text(
                        text = categoria,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color(0xFFAB47BC)
                    )
                    LazyRow {
                        items(listaRestaurantes.size) { index ->
                            restauranteCard(
                                restaurante = listaRestaurantes[index],
                                onClick = {
                                    navController.navigate("menu/${listaRestaurantes[index].id}")
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}