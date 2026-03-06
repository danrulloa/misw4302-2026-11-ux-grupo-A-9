package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.R
import com.misw4302ux9.sistemamedicamentos.ui.components.AppButton
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTextField
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun RegistroScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToSeleccionUsuario: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    ScreenBackground {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 77.dp, end = 78.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(71.dp))

            Text(
                text = "REGISTRO",
                style = MaterialTheme.typography.headlineLarge,
                color = TextosBase,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(25.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(width = 95.dp, height = 114.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Crea tu cuenta principal. Luego podrás agregar perfiles familiares.",
                style = MaterialTheme.typography.bodyMedium,
                color = TextosBase,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            AppTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = "Nombre",
                leadingIcon = Icons.Outlined.Person
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppTextField(
                value = correo,
                onValueChange = { correo = it },
                label = "Correo",
                leadingIcon = Icons.Outlined.Email
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppTextField(
                value = password,
                onValueChange = { password = it },
                label = "Nueva contraseña",
                leadingIcon = Icons.Outlined.VpnKey,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirmar contraseña",
                leadingIcon = Icons.Outlined.VpnKey,
                isPassword = true,
                supportingText = "Las contraseñas deben ser identicas"
            )

            Spacer(modifier = Modifier.height(40.dp))

            AppButton(
                text = "Registrar",
                icon = Icons.Outlined.PersonAdd,
                containerColor = PrimarioBase,
                contentColor = FondoBase,
                onClick = onNavigateToSeleccionUsuario
            )
            
            TextButton(
                onClick = onNavigateToLogin,
                modifier = Modifier.height(40.dp)
            ) {
                Text(
                    text = "¿Usuario registrado? Vuelve a Login",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextosBase
                )
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun RegistroScreenPreview() {
    SistemaMedicamentosTheme {
        RegistroScreen(onNavigateToLogin = {}, onNavigateToSeleccionUsuario = {})
    }
}
