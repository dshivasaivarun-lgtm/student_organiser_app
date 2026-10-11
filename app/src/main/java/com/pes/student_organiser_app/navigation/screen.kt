package com.pes.student_organiser_app.navigation

sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard")
    data object Assignments : Screen("assignments")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object AddAssignment : Screen("add_assignment")
}