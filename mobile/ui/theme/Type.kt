package com.misw4302ux9.sistemamedicamentos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.misw4302ux9.sistemamedicamentos.R

// Definición de la familia de fuente Nunito con todos los pesos usados
val Nunito = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal),
    Font(R.font.nunito_medium, FontWeight.Medium), // Recomendado añadir a res/font
    Font(R.font.nunito_bold, FontWeight.Bold)
)

val Typography = Typography(
    // --- ENCABEZADOS (Mapeados a Display) ---
    displayLarge = TextStyle( // Encabezado Grande
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle( // Encabezado Medium
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 35.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle( // Encabezado Pequeño
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),

    // --- TÍTULOS (Mapeados a Headline) ---
    headlineLarge = TextStyle( // Título Grande
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle( // Título Medium
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.35.sp
    ),
    headlineSmall = TextStyle( // Título Pequeño
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    // --- CUERPO (Mapeados a Body) ---
    bodyLarge = TextStyle( // Cuerpo Grande
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle( // Cuerpo Medium
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle( // Cuerpo Pequeño
        fontFamily = Nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // --- ETIQUETAS (Mapeados a Label) ---
    labelLarge = TextStyle( // Etiqueta Grande
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle( // Etiqueta Medium
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle( // Etiqueta Pequeña
        fontFamily = Nunito,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
