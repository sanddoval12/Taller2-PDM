package com.pdmtaller2.DavidSandoval_00379422.ui.navegacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.*
import com.pdmtaller2.DavidSandoval_00379422.ui.screens.*
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Restaurantes", Icons.Default.Fastfood)
    object Search : BottomNavItem("search", "Buscar", Icons.Default.Search)
    object Orders : BottomNavItem("orders", "Mis Órdenes", Icons.Default.History)
}

@Composable
fun appNavigator(viewModel: foodSpotViewModel) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Orders
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentDestination = navController.currentBackStackEntryAsState().value?.destination
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentDestination?.route == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { inclusive = false }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(bottom = padding.calculateBottomPadding())

        ) {
            composable("home") { homeScreen(viewModel, navController) }
            composable("search") { busquedaScreen(viewModel, navController) }
            composable("orders") { ordersScreen(viewModel) }
            composable("menu/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                id?.let { menuScreen(viewModel, navController, it) }
            }
        }
    }
}
