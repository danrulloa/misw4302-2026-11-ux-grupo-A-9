package com.misw4302ux9.sistemamedicamentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Aplicamos un esquema de colores basado en tus colores de res/values/colors.xml
            val myColorScheme = lightColorScheme(
                primary = colorResource(id = R.color.primario_base),
                secondary = colorResource(id = R.color.secundario_base),
                tertiary = colorResource(id = R.color.acento_base),
                background = colorResource(id = R.color.fondo_base),
                surface = colorResource(id = R.color.fondo_base),
                error = colorResource(id = R.color.error_base),
                onPrimary = colorResource(id = R.color.white),
                onSecondary = colorResource(id = R.color.white),
                onBackground = colorResource(id = R.color.textos_base),
                onSurface = colorResource(id = R.color.textos_base)
            )

            MaterialTheme(colorScheme = myColorScheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android con Material 3",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary // Usa el color primario que definiste
    )
}