
package com.pes.student_organiser_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.Course
import com.pes.student_organiser_app.Assignment
import com.pes.student_organiser_app.navigation.Screen
import com.pes.student_organiser_app.ui.components.AssignmentCard
import com.pes.student_organiser_app.ui.components.BottomBar
import com.pes.student_organiser_app.ui.components.CourseInfo

private val courses = listOf(
    Course("Android App Development", "AAD", "Course Faculty", 0.75f),
    Course("Database Management Systems", "DBMS", "Course Faculty", 0.60f),
    Course("Machine Learning", "ML", "Course Faculty", 0.50f),
    Course("Software Engineering", "SE", "Course Faculty", 0.70f),
    Course("Augmented Virtual Reality", "AVR", "Course Faculty", 0.40f)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavHostController,
    assignments: List<Assignment>,
    onToggleComplete: (Assignment) -> Unit,
    onAddAssignment: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Welcome back, Varun!") })
        },
        bottomBar = {
            BottomBar(navController, Screen.Dashboard.route)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddAssignment) {
                Text("+", style = MaterialTheme.typography.headlineSmall)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Text(
                    "Quick Stats",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(
                        "Active Courses",
                        courses.size.toString(),
                        Modifier.weight(1f)
                    )
                    StatCard(
                        "Pending Tasks",
                        assignments.count { !it.isCompleted }.toString(),
                        Modifier.weight(1f)
                    )
                }

                Spacer(Modifier.height(20.dp))
                Text(
                    "Active Courses",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
            }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(courses) { course ->
                        CourseInfo(
                            course.courseName,
                            course.courseCode,
                            course.instructor,
                            course.progress
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))
                Text(
                    "Assignments Due Soon",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(6.dp))
            }

            items(assignments.filter { !it.isCompleted }.take(2), key = { it.id }) { assignment ->
                AssignmentCard(
                    title = assignment.title,
                    course = assignment.course,
                    dueDate = assignment.dueDate,
                    priority = assignment.priority,
                    isCompleted = assignment.isCompleted,
                    onToggleComplete = { onToggleComplete(assignment) }
                )
            }
        }
    }
}

@Composable
private fun StatCard(
    label: String,
    value: String,
    modifier: Modifier
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(label)
        }
    }
}
