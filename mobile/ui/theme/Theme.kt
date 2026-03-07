package com.misw4302ux9.sistemamedicamentos.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimarioBase,
    secondary = SecundarioBase,
    tertiary = AcentoBase,
    background = FondoBase,
    surface = White,
    error = ErrorBase,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = TextosBase,
    onSurface = TextosBase
)

@Composable
fun SistemaMedicamentosTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography, // Aquí estamos aplicando la tipografía Nunito globalmente
        content = content
    )
}
