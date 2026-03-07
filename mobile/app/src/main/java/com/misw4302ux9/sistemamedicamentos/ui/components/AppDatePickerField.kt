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
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AppDatePickerField(
    value: String,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
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
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Seleccionar fecha",
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
            
            // Capa para capturar el click
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { onClick() }
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDatePickerFieldPreview() {
    SistemaMedicamentosTheme {
        Box(modifier = Modifier.padding(16.dp).background(FondoBase)) {
            AppDatePickerField(
                value = "28 Feb 2026",
                onClick = {},
                label = "Fecha Inicio",
                modifier = Modifier.width(215.dp)
            )
        }
    }
}
