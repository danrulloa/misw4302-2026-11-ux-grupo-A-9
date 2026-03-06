package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.R
import com.misw4302ux9.sistemamedicamentos.ui.components.AppUserListItem
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase

@Composable
fun SeleccionUsuarioScreen(modifier: Modifier = Modifier) {
    // ScreenBackground proporciona el color de fondo (FondoBase), la textura y el degradado inferior
    ScreenBackground {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Título principal centrado
            Text(
                text = "¿QUÉ PERFIL QUIERES USAR?",
                style = MaterialTheme.typography.displayMedium,
                color = TextosBase,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Logo del sistema
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(width = 100.dp, height = 120.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Sección TU PERFIL - Alineado a 20dp para coincidir con el inicio del componente de lista
            Text(
                text = "TU PERFIL",
                style = MaterialTheme.typography.headlineMedium,
                color = TextosBase,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Selecciona tu perfil o uno de tu familia para ver sus alarmas y registrar tomas.",
                style = MaterialTheme.typography.bodyMedium,
                color = TextosBase.copy(alpha = 0.8f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppUserListItem(
                monogram = "A",
                headline = "Alejandra",
                supportingText = "(Tu perfil)",
                trailingText = "Entrar",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Divisor alineado con los márgenes de 20dp
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                thickness = 1.dp,
                color = AcentoBase.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sección PERFILES DE TU FAMILIA
            Text(
                text = "PERFILES DE TU FAMILIA",
                style = MaterialTheme.typography.headlineMedium,
                color = TextosBase,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Elige el perfil de alguno de tus familiares y gestionar sus alarmas y actividades",
                style = MaterialTheme.typography.bodyMedium,
                color = TextosBase.copy(alpha = 0.8f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Los perfiles familiares se crean y editan en la versión Web",
                style = MaterialTheme.typography.bodySmall,
                color = TextosBase.copy(alpha = 0.6f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppUserListItem(
                monogram = "C",
                headline = "Cecilia",
                supportingText = "(Mamá)",
                trailingText = "Entrar",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppUserListItem(
                monogram = "P",
                headline = "Polo",
                supportingText = "(Mascota)",
                trailingText = "Entrar",
                onClick = { /* TODO */ }
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun SeleccionUsuarioScreenPreview() {
    SistemaMedicamentosTheme {
        SeleccionUsuarioScreen()
    }
}
