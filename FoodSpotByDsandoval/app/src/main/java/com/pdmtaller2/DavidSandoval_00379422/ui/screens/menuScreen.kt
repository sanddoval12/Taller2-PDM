package com.pdmtaller2.DavidSandoval_00379422.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.DavidSandoval_00379422.ui.componentes.platoCard
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun menuScreen(viewModel: foodSpotViewModel, navController: NavController, restauranteId: Int) {
    val restaurante = viewModel.obtenerPorId(restauranteId) ?: return
    var filtro by remember { mutableStateOf("") }
    val platillosFiltrados = viewModel.filtrarMenu(restaurante, filtro)
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(restaurante.nombre) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)) {

            Text(text = restaurante.descripcion, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = filtro,
                onValueChange = { filtro = it },
                label = { Text("Buscar platillo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(platillosFiltrados.size) { index ->
                    platoCard(
                        platillo = platillosFiltrados[index],
                        onAgregar = {
                            viewModel.agregarAlCarrito(platillosFiltrados[index], restaurante)
                            Toast.makeText(context, "${platillosFiltrados[index].nombre} agregado al carrito", Toast.LENGTH_SHORT).show()
                        }

                    )
                }
            }
        }
    }
}
