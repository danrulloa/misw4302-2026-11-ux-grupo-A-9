package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.White

@Composable
fun AppUserListItem(
    monogram: String,
    headline: String,
    supportingText: String,
    trailingText: String = "",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp) // Margen de 20dp a cada lado según la imagen
            .height(72.dp)
            .clickable(onClick = onClick),
        color = Color.White,
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp), // Padding interno para los elementos
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Monogram (Avatar con letra)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(PrimarioBase),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = monogram,
                    style = MaterialTheme.typography.titleMedium,
                    color = White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Textos Centrales
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = headline,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextosBase
                )
                Text(
                    text = supportingText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextosBase.copy(alpha = 0.7f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Sección Derecha (Texto + Icono)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (trailingText.isNotEmpty()) {
                    Text(
                        text = trailingText,
                        style = MaterialTheme.typography.labelLarge,
                        color = TextosBase.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = PrimarioBase,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppUserListItemPreview() {
    SistemaMedicamentosTheme {
        Column(modifier = Modifier.background(FondoBase).padding(vertical = 16.dp)) {
            AppUserListItem(
                monogram = "A",
                headline = "Alejandra",
                supportingText = "(Tu perfil)",
                trailingText = "Entrar"
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppUserListItem(
                monogram = "C",
                headline = "Cecilia",
                supportingText = "(Hija)"
            )
        }
    }
}
