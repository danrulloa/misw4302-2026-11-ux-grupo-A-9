package com.misw4302ux9.sistemamedicamentos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.misw4302ux9.sistemamedicamentos.ui.screens.CrearAlarmaScreen
import com.misw4302ux9.sistemamedicamentos.ui.screens.HistorialScreen
import com.misw4302ux9.sistemamedicamentos.ui.screens.HomePersonalScreenAlejandra
import com.misw4302ux9.sistemamedicamentos.ui.screens.HomePersonalScreenCecilia
import com.misw4302ux9.sistemamedicamentos.ui.screens.HomePersonalScreenPolo
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
            SeleccionUsuarioScreen(
                onNavigateToAlejandra = { navController.navigate("home_alejandra") },
                onNavigateToCecilia = { navController.navigate("home_cecilia") },
                onNavigateToPolo = { navController.navigate("home_polo") }
            )
        }
        composable("home_alejandra") {
            HomePersonalScreenAlejandra(
                onBackClick = { navController.popBackStack() },
                onNavigateToHistorial = { navController.navigate("historial") },
                onNavigateToCrearAlarma = { navController.navigate("crear_alarma") }
            )
        }
        composable("home_cecilia") {
            HomePersonalScreenCecilia(
                onBackClick = { navController.popBackStack() },
                onNavigateToHistorial = { navController.navigate("historial") },
                onNavigateToCrearAlarma = { navController.navigate("crear_alarma") }
            )
        }
        composable("home_polo") {
            HomePersonalScreenPolo(
                onBackClick = { navController.popBackStack() },
                onNavigateToHistorial = { navController.navigate("historial") },
                onNavigateToCrearAlarma = { navController.navigate("crear_alarma") }
            )
        }
        composable("crear_alarma") {
            CrearAlarmaScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToHistorial = {
                    navController.navigate("historial") {
                        popUpTo("home_alejandra") // O el home correspondiente
                    }
                }
            )
        }
        composable("historial") {
            HistorialScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToAlarmas = {
                    navController.popBackStack()
                }
            )
        }
    }
}
