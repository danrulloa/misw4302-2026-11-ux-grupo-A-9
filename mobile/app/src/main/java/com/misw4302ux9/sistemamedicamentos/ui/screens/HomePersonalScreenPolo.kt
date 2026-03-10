package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.components.AppSwitchListItem
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTabs
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTopBar
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.White

@Composable
fun HomePersonalScreenPolo(
    onBackClick: () -> Unit,
    onNavigateToHistorial: () -> Unit,
    onNavigateToCrearAlarma: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var alarm1Checked by remember { mutableStateOf(true) }
    var alarm2Checked by remember { mutableStateOf(true) }
    var alarm3Checked by remember { mutableStateOf(true) }

    ScreenBackground {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Barra superior
                AppTopBar(
                    title = "Polo (Mascota)",
                    onBackClick = onBackClick
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Pestañas
                AppTabs(
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { index ->
                        if (index == 1) {
                            onNavigateToHistorial()
                        } else {
                            selectedTabIndex = index
                        }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Lista de alarmas (Contenido de la pestaña Alarmas)
                if (selectedTabIndex == 0) {
                    AppSwitchListItem(
                        headline = "Antiparasitario",
                        supportingText = "9:00 AM (Cada 4 semanas)",
                        checked = alarm1Checked,
                        onCheckedChange = { alarm1Checked = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AppSwitchListItem(
                        headline = "Vitaminas Pelo",
                        supportingText = "10:00 AM (Cada semana)",
                        checked = alarm2Checked,
                        onCheckedChange = { alarm2Checked = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AppSwitchListItem(
                        headline = "Refuerzo Articulaciones",
                        supportingText = "8:00 AM (Cada 2 semanas)",
                        checked = alarm3Checked,
                        onCheckedChange = { alarm3Checked = it }
                    )
                }

                Spacer(modifier = Modifier.height(80.dp)) // Espacio para el FAB
            }

            // Botón de acción flotante (FAB)
            FloatingActionButton(
                onClick = onNavigateToCrearAlarma,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp),
                containerColor = PrimarioBase,
                contentColor = White,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Alarma"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun HomePersonalScreenPoloPreview() {
    SistemaMedicamentosTheme {
        HomePersonalScreenPolo(onBackClick = {}, onNavigateToHistorial = {}, onNavigateToCrearAlarma = {})
    }
}
