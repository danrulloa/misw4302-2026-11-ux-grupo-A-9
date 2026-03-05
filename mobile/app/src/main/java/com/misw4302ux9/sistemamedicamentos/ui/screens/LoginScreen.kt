package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Login
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.VpnKey
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.R
import com.misw4302ux9.sistemamedicamentos.ui.components.AppButton
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTextField
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun LoginScreen(
    onNavigateToRegistro: () -> Unit,
    onNavigateToSeleccionUsuario: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ScreenBackground {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 77.dp, end = 78.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Posicionamiento absoluto según Figma
            Spacer(modifier = Modifier.height(71.dp))

            Text(
                text = "LOGIN",
                style = MaterialTheme.typography.displayMedium,
                color = TextosBase
            )

            // Espacio al logo (Logo top = 130)
            Spacer(modifier = Modifier.height(25.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(width = 125.dp, height = 150.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(48.dp))

            AppTextField(
                value = email,
                onValueChange = { email = it },
                label = "Correo",
                leadingIcon = Icons.Outlined.Email
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppTextField(
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                leadingIcon = Icons.Outlined.VpnKey,
                isPassword = true
            )

            TextButton(
                onClick = { /* TODO */ },
                modifier = Modifier.height(30.dp)
            ) {
                Text(
                    text = "Recuperar contraseña",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextosBase
                )
            }

            // Espaciador final para el botón (Botón top = 595)
            Spacer(modifier = Modifier.height(75.dp))

            AppButton(
                text = "Ingresar",
                icon = Icons.AutoMirrored.Outlined.Login,
                containerColor = PrimarioBase,
                contentColor = FondoBase,
                onClick = onNavigateToSeleccionUsuario
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppButton(
                text = "Registrar",
                icon = Icons.Outlined.PersonAdd,
                containerColor = AcentoBase,
                contentColor = FondoBase,
                onClick = onNavigateToRegistro
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun LoginScreenPreview() {
    SistemaMedicamentosTheme {
        LoginScreen(onNavigateToRegistro = {}, onNavigateToSeleccionUsuario = {})
    }
}
