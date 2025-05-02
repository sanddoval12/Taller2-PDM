package com.pdmtaller2.DavidSandoval_00379422.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.DavidSandoval_00379422.data.modelo.Orden

@Composable
fun ordenesCard(orden: Orden) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(orden.plato.imagenUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = orden.plato.nombre, style = MaterialTheme.typography.titleMedium)
                Text(text = orden.plato.descripcion, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Restaurante: ${orden.restaurante}", style = MaterialTheme.typography.bodySmall)
                Text("Categoría: ${orden.categoria}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
