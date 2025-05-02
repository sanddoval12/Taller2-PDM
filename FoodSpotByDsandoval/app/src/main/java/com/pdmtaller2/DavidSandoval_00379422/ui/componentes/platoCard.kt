package com.pdmtaller2.DavidSandoval_00379422.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.DavidSandoval_00379422.data.modelo.Plato

@Composable
fun platoCard(platillo: Plato, onAgregar: (Plato) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(platillo.imagenUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(platillo.nombre, style = MaterialTheme.typography.titleMedium)
                Text(platillo.descripcion, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = { onAgregar(platillo) }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)) {
                    Text("Agregar al carrito")
                }
            }
        }
    }
}
