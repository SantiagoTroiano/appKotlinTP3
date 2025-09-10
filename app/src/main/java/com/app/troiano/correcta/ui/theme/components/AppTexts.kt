package com.app.troiano.correcta.ui.theme.components

import androidx.annotation.StringRes
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.app.troiano.correcta.R

// Ejemplo de un componente para Títulos Principales
@Composable
fun TituloPrincipal(
    @StringRes textResId: Int, // Recibe el ID del recurso de string
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified, // Permite sobrescribir el color, por defecto usa el del estilo local
    textAlign: TextAlign? = null,
    // ... otros parámetros comunes de Text que quieras exponer
) {
    Text(
        text = stringResource(id = textResId),
        modifier = modifier,
        color = color,
        fontSize = 28.sp, // Estilo específico para este tipo de título
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
}

// Ejemplo de un componente para Subtítulos
@Composable
fun SubtituloApp(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF333333), // Ejemplo de color por defecto para este componente
    textAlign: TextAlign? = TextAlign.Center,
    // ... otros parámetros
) {
    Text(
        text = stringResource(id = textResId),
        modifier = modifier,
        color = color,
        fontSize = 14.sp,
        textAlign = textAlign
    )
}

// Un Text genérico que toma un StringRes y permite más personalización
@Composable
fun TextoLocalizado(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = stringResource(id = textResId),
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}
