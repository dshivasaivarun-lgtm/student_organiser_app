
package com.pes.student_organiser_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pes.student_organiser_app.navigation.Screen
import com.pes.student_organiser_app.ui.screens.AssignmentsScreen
import com.pes.student_organiser_app.ui.screens.DashboardScreen
import com.pes.student_organiser_app.ui.screens.ProfileScreen
import com.pes.student_organiser_app.ui.screens.SettingsScreen
import com.pes.student_organiser_app.ui.theme.Student_organiser_appTheme
import com.pes.student_organiser_app.ui.screens.AddAssignmentScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.LaunchedEffect

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Student_organiser_appTheme {
                var darkMode by remember { mutableStateOf(false) }
                var defaultScreen by remember {
                    mutableStateOf(Screen.Dashboard.route)
                }
                Student_organiser_appTheme(
                    darkTheme = darkMode
                ) {
                    val navController = rememberNavController()

                    val assignments = remember {
                        mutableStateListOf(
                            Assignment(
                                1,
                                "Compose UI Assignment",
                                "Android App Development",
                                "12 Oct 2026",
                                "High"
                            ),
                            Assignment(
                                2,
                                "Database Design",
                                "DBMS",
                                "14 Oct 2026",
                                "Medium"
                            ),
                            Assignment(
                                3,
                                "ML Model Implementation",
                                "Machine Learning",
                                "16 Oct 2026",
                                "High"
                            ),
                            Assignment(
                                4,
                                "Software Requirements Document",
                                "Software Engineering",
                                "18 Oct 2026",
                                "Low"
                            ),
                            Assignment(
                                5,
                                "AR/VR Interface Prototype",
                                "Augmented Virtual Reality",
                                "20 Oct 2026",
                                "Medium"
                            )
                        )
                    }

                    NavHost(
                        navController = navController,
                        startDestination = defaultScreen
                    )  {
                        composable(Screen.Dashboard.route) {
                            DashboardScreen(
                                navController = navController,
                                assignments = assignments,
                                onToggleComplete = { assignment ->
                                    val index = assignments.indexOfFirst {
                                        it.id == assignment.id
                                    }
                                    if (index != -1) {
                                        assignments[index] = assignment.copy(
                                            isCompleted = !assignment.isCompleted
                                        )
                                    }
                                },
                                onAddAssignment = {
                                    navController.navigate(
                                        Screen.AddAssignment.route
                                    )
                                }
                            )
                        }

                        composable(Screen.Assignments.route) {
                            AssignmentsScreen(
                                navController = navController,
                                assignments = assignments,
                                onToggleComplete = { assignment ->
                                    val index = assignments.indexOfFirst {
                                        it.id == assignment.id
                                    }
                                    if (index != -1) {
                                        assignments[index] = assignment.copy(
                                            isCompleted = !assignment.isCompleted
                                        )
                                    }
                                }
                            )
                        }

                        composable(Screen.Profile.route) {
                            ProfileScreen(navController)
                        }

                        composable(Screen.Settings.route) {
                            SettingsScreen(
                                navController = navController,
                                darkMode = darkMode,
                                onDarkModeChange = { darkMode = it },
                                defaultScreen = defaultScreen,
                                onDefaultScreenChange = { route ->
                                    defaultScreen = route

                                    navController.navigate(route) {
                                        popUpTo(Screen.Dashboard.route) {
                                            inclusive = false
                                        }
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }

                        composable(Screen.AddAssignment.route) {
                            AddAssignmentScreen(
                                navController = navController,
                                onSave = { newAssignment ->
                                    assignments.add(newAssignment)
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
