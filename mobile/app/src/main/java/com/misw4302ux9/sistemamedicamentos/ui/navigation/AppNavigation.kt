package com.misw4302ux9.sistemamedicamentos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.misw4302ux9.sistemamedicamentos.ui.screens.LoginScreen
import com.misw4302ux9.sistemamedicamentos.ui.screens.RegistroScreen
import com.misw4302ux9.sistemamedicamentos.ui.screens.SeleccionUsuarioScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onNavigateToRegistro = {
                    navController.navigate("registro")
                },
                onNavigateToSeleccionUsuario = {
                    navController.navigate("seleccion_usuario") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("registro") {
            RegistroScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onNavigateToSeleccionUsuario = {
                    navController.navigate("seleccion_usuario") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("seleccion_usuario") {
            SeleccionUsuarioScreen()
        }
    }
}
