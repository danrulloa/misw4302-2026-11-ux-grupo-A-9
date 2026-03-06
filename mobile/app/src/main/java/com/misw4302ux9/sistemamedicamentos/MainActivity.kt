package com.misw4302ux9.sistemamedicamentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.misw4302ux9.sistemamedicamentos.ui.navigation.AppNavigation
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SistemaMedicamentosTheme {
                AppNavigation()
            }
        }
    }
}
