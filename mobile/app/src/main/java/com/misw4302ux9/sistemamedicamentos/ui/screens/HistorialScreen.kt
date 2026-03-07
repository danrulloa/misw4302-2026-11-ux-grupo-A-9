package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTabs
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTopBar
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun HistorialScreen(
    onBackClick: () -> Unit,
    onNavigateToAlarmas: () -> Unit,
    modifier: Modifier = Modifier
) {
    ScreenBackground {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Barra superior
            AppTopBar(
                title = "Alejandra (Tu perfil)",
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Pestañas (Historial seleccionado: index 1)
            AppTabs(
                selectedTabIndex = 1,
                onTabSelected = { index ->
                    if (index == 0) onNavigateToAlarmas()
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Texto informativo
            Text(
                text = "Acá puedes encontrar el historico de alarmas y consumo",
                style = MaterialTheme.typography.bodyMedium,
                color = TextosBase,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Grupo de Historial 1: Jueves, 5 de Febrero
            HistorialGroup(
                fecha = "Jueves, 5 de Febrero",
                items = listOf(
                    "Ibuprofeno" to "10:00 PM",
                    "Ibuprofeno" to "8:00 PM",
                    "Ibuprofeno" to "2:00 PM"
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Grupo de Historial 2: Miércoles, 4 de Febrero
            HistorialGroup(
                fecha = "Miércoles, 4 de Febrero",
                items = listOf(
                    "Ibuprofeno" to "10:00 PM",
                    "Ibuprofeno" to "8:00 PM",
                    "Ibuprofeno" to "2:00 PM"
                )
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun HistorialGroup(
    fecha: String,
    items: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(Color.White, RoundedCornerShape(4.dp))
    ) {
        // Cabecera de fecha
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = fecha,
                style = MaterialTheme.typography.titleMedium,
                color = TextosBase
            )
        }
        
        HorizontalDivider(color = AcentoBase.copy(alpha = 0.3f), thickness = 1.dp)

        // Lista de consumos
        items.forEachIndexed { index, (nombre, hora) ->
            HistorialItemRow(nombre, hora)
            if (index < items.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AcentoBase.copy(alpha = 0.1f),
                    thickness = 1.dp
                )
            }
        }
        
        // Línea final vacía como se ve en el mockup
        HorizontalDivider(color = AcentoBase.copy(alpha = 0.3f), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun HistorialItemRow(
    nombre: String,
    hora: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = AcentoBase,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = nombre,
            style = MaterialTheme.typography.bodyLarge,
            color = TextosBase,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = hora,
            style = MaterialTheme.typography.bodyMedium,
            color = TextosBase.copy(alpha = 0.6f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun HistorialScreenPreview() {
    SistemaMedicamentosTheme {
        HistorialScreen(onBackClick = {}, onNavigateToAlarmas = {})
    }
}
