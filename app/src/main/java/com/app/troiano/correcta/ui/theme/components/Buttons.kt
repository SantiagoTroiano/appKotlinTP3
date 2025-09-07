package com.app.troiano.correcta.ui.theme.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BotonPrincipalApp(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier, // Permite pasar modificadores adicionales desde fuera
    colorFondo: Color, // Hacemos el color del fondo un parámetro para flexibilidad
) {
    Button(
        onClick = onClick,
        modifier = modifier // Usamos el modifier que nos pasan
            .height(48.dp), // Mantenemos la altura fija como característica de este botón
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo)
    ) {
        Text(texto)
    }
}