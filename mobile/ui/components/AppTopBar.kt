package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.R
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun AppTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp), // Altura estándar de TopAppBar en M3
        color = Color.Transparent // Para que se vea el fondo de ScreenBackground
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp), // Espaciado lateral de 4dp según la imagen
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Leading Icon: Arrow Back
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = PrimarioBase,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Headline
            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall, // Según el tamaño visual de la imagen
                color = PrimarioBase,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )

            // Trailing Icon: Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(40.dp) // Tamaño pequeño para el logo en la barra
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    SistemaMedicamentosTheme {
        AppTopBar(
            title = "Alejandra (Tu perfil)",
            onBackClick = {}
        )
    }
}
