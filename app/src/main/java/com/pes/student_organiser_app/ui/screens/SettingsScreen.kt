
package com.pes.student_organiser_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.navigation.Screen
import com.pes.student_organiser_app.ui.components.AppBar
import com.pes.student_organiser_app.ui.components.BottomBar



@Composable
fun SettingsScreen(
    navController: NavHostController,
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    defaultScreen: String,
    onDefaultScreenChange: (String) -> Unit
) {
    var notifications by remember { mutableStateOf(true) }


    Scaffold(
        topBar = {
            AppBar(title = "Settings")
        },
        bottomBar = {
            BottomBar(navController, Screen.Settings.route)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                "Appearance",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Dark Mode", modifier = Modifier.weight(1f))
                Switch(
                    checked = darkMode,
                    onCheckedChange = onDarkModeChange
                )
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Notifications", modifier = Modifier.weight(1f))
                Switch(
                    checked = notifications,
                    onCheckedChange = { notifications = it }
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "Default Screen",
                style = MaterialTheme.typography.titleMedium
            )

            listOf(
                "Dashboard" to Screen.Dashboard.route,
                "Assignments" to Screen.Assignments.route
            ).forEach { (label, route) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = defaultScreen == route,
                        onClick = { onDefaultScreenChange(route) }
                    )
                    Text(label)
                }
            }
        }
    }
}
