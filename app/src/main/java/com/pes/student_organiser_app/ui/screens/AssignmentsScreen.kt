
package com.pes.student_organiser_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.Assignment
import com.pes.student_organiser_app.navigation.Screen
import com.pes.student_organiser_app.ui.components.AppBar
import com.pes.student_organiser_app.ui.components.AssignmentCard
import com.pes.student_organiser_app.ui.components.BottomBar

@Composable
fun AssignmentsScreen(
    navController: NavHostController,
    assignments: List<Assignment>,
    onToggleComplete: (Assignment) -> Unit
) {
    var selectedFilter by remember { mutableStateOf("All") }

    val filteredAssignments = when (selectedFilter) {
        "Pending" -> assignments.filter { !it.isCompleted }
        "Completed" -> assignments.filter { it.isCompleted }
        else -> assignments
    }

    Scaffold(
        topBar = {
            AppBar(title = "Assignments")
        },
        bottomBar = {
            BottomBar(navController, Screen.Assignments.route)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("All", "Pending", "Completed").forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) }
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredAssignments, key = { it.id }) { assignment ->
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
}
