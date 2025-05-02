package com.pdmtaller2.DavidSandoval_00379422.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.shape.RoundedCornerShape
import com.pdmtaller2.DavidSandoval_00379422.data.modelo.Restaurante

@Composable
fun restauranteCard(restaurante: Restaurante, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(restaurante.imagenUrl),
                contentDescription = null,
                modifier = Modifier.height(100.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = restaurante.nombre,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
