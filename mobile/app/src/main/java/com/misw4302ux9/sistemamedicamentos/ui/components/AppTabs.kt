package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme

@Composable
fun AppTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf(
        "Alarmas" to Icons.Default.Alarm,
        "Historial" to Icons.Default.History
    )

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp) // Margen de 20dp a cada lado (372dp de ancho total en pantalla de 412dp)
            .height(48.dp),
        containerColor = Color.Transparent,
        contentColor = PrimarioBase,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = AcentoBase,
                    height = 2.dp
                )
            }
        },
        divider = {} // Sin divisor visible según diseño
    ) {
        tabs.forEachIndexed { index, (label, icon) ->
            val isSelected = selectedTabIndex == index
            LeadingIconTab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selectedContentColor = PrimarioBase,
                unselectedContentColor = PrimarioBase.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTabsPreview() {
    SistemaMedicamentosTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            AppTabs(selectedTabIndex = 0, onTabSelected = {})
            Spacer(modifier = Modifier.height(16.dp))
            AppTabs(selectedTabIndex = 1, onTabSelected = {})
        }
    }
}
