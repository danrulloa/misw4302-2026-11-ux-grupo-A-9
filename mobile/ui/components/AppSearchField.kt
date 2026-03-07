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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun AppSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    suggestions: List<String> = emptyList(),
    onSuggestionSelected: (String) -> Unit = {}
) {
    val showSuggestions = value.isNotEmpty()

    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = PrimarioBase,
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(4.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AcentoBase,
                    unfocusedBorderColor = AcentoBase.copy(alpha = 0.5f),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = PrimarioBase
                ),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = TextosBase),
                singleLine = true
            )

            // Etiqueta flotante sobre el borde
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

        // Lista de sugerencias (Simulada)
        if (showSuggestions && suggestions.isNotEmpty()) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-2).dp) // Unir ligeramente con el campo de texto
                    .zIndex(1f),
                color = Color.White,
                tonalElevation = 4.dp,
                shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, AcentoBase.copy(alpha = 0.5f))
            ) {
                Column {
                    suggestions.forEachIndexed { index, suggestion ->
                        Text(
                            text = suggestion,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { 
                                    onSuggestionSelected(suggestion)
                                    onValueChange(suggestion)
                                }
                                .padding(16.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextosBase
                        )
                        if (index < suggestions.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 8.dp),
                                color = AcentoBase.copy(alpha = 0.2f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppSearchFieldPreview() {
    SistemaMedicamentosTheme {
        Box(modifier = Modifier.padding(16.dp).background(FondoBase)) {
            AppSearchField(
                value = "Ibu",
                onValueChange = {},
                label = "Medicamento",
                suggestions = listOf("Ibuprofeno", "Magnesio", "Enalapril")
            )
        }
    }
}
