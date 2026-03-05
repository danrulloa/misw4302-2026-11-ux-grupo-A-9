package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    isPassword: Boolean = false,
    supportingText: String? = null
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                leadingIcon = leadingIcon?.let {
                    { 
                        Icon(
                            imageVector = it, 
                            contentDescription = null, 
                            tint = PrimarioBase
                        ) 
                    }
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
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = TextosBase),
                singleLine = true
            )

            // Contenedor de Etiqueta (Label) EXACTO a Figma
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .offset(y = (-12).dp) // Offset exacto de Figma
                    .height(16.dp) // Altura exacta de Figma
                    .background(FondoBase) // Fondo para tapar el borde
                    .padding(horizontal = 4.dp), // Padding exacto de Figma
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall, // Nunito 12sp / LineHeight 16sp
                    color = PrimarioBase
                )
            }
        }
        
        if (supportingText != null) {
            Text(
                text = supportingText,
                style = MaterialTheme.typography.bodySmall,
                color = AcentoBase,
                modifier = Modifier.padding(top = 4.dp, start = 12.dp)
            )
        }
    }
}
