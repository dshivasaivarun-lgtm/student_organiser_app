
package com.pes.student_organiser_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.navigation.Screen
import com.pes.student_organiser_app.ui.components.AppBar
import com.pes.student_organiser_app.ui.components.BottomBar
import com.pes.student_organiser_app.ui.components.StudentProfile

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppBar(title = "My Profile")
        },
        bottomBar = {
            BottomBar(navController, Screen.Profile.route)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StudentProfile(
                studentName = "D. Shiva Sai Varun",
                studentId = "PES1UG24CS150",
                major = "Computer Science"
            )

            Text(
                text = "Academic Overview",
                style = MaterialTheme.typography.titleLarge
            )

            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Semester: 5")
                    Text("Active Courses: 3")
                    Text("Assignments Completed: 1")
                    Text("Assignments Pending: 2")
                }
            }
        }
    }
}
