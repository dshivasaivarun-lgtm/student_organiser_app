package com.pes.student_organiser_app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val items = listOf(
        Triple(Screen.Dashboard.route, "Dashboard", Icons.Default.Dashboard),
        Triple(Screen.Assignments.route, "Assignments", Icons.Default.List),
        Triple(Screen.Profile.route, "Profile", Icons.Default.Person),
        Triple(Screen.Settings.route, "Settings", Icons.Default.Settings)
    )

    NavigationBar {
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            popUpTo(Screen.Dashboard.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) }
            )
        }
    }
}