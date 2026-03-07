package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun AppDropdownField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    options: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Desplegar opciones",
                        tint = PrimarioBase,
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AcentoBase.copy(alpha = 0.5f),
                    unfocusedBorderColor = AcentoBase.copy(alpha = 0.5f),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledBorderColor = AcentoBase.copy(alpha = 0.5f),
                    disabledContainerColor = Color.White
                ),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = TextosBase),
                singleLine = true,
                enabled = false
            )

            // Capa para capturar el click y abrir el menú
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expanded = true }
            )

            // Etiqueta flotante
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .offset(y = (-12).dp)
                    .height(16.dp)
                    .background(FondoBase)
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall,
                    color = PrimarioBase
                )
            }

            // Menú desplegable
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.9f) // Ajustar según sea necesario
                    .background(Color.White)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextosBase
                            )
                        },
                        onClick = {
                            onValueChange(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDropdownFieldPreview() {
    SistemaMedicamentosTheme {
        Box(modifier = Modifier.padding(16.dp).background(FondoBase)) {
            var selectedOption by remember { mutableStateOf("Días") }
            AppDropdownField(
                value = selectedOption,
                onValueChange = { selectedOption = it },
                label = "Frecuencia",
                options = listOf("Minutos", "Horas", "Días", "Semanas"),
                modifier = Modifier.width(215.dp)
            )
        }
    }
}
