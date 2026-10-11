
package com.pes.student_organiser_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pes.student_organiser_app.Assignment
import com.pes.student_organiser_app.ui.components.AppBar
import com.pes.student_organiser_app.ui.components.AssignmentForm

@Composable
fun AddAssignmentScreen(
    navController: NavHostController,
    onSave: (Assignment) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("Medium") }
    var description by remember { mutableStateOf("") }
    var reminder by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppBar(
                title = "Add Assignment",
                canNavigateBack = true,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Assignment Details",
                style = MaterialTheme.typography.titleLarge
            )

            AssignmentForm(
                title = title,
                course = course,
                dueDate = dueDate,
                priority = priority,
                description = description,
                reminder = reminder,
                onTitleChange = {
                    title = it
                    errorMessage = ""
                },
                onCourseChange = {
                    course = it
                    errorMessage = ""
                },
                onDueDateChange = {
                    dueDate = it
                    errorMessage = ""
                },
                onPriorityChange = { priority = it },
                onDescriptionChange = { description = it },
                onReminderChange = { reminder = it }
            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TextButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }

                Button(
                    onClick = {
                        when {
                            title.isBlank() ->
                                errorMessage = "Please enter an assignment title."

                            course.isBlank() ->
                                errorMessage = "Please enter a course name or code."

                            dueDate.isBlank() ->
                                errorMessage = "Please enter a due date."

                            else -> {
                                val newAssignment = Assignment(
                                    id = System.currentTimeMillis().toInt(),
                                    title = title.trim(),
                                    course = course.trim(),
                                    dueDate = dueDate.trim(),
                                    priority = priority
                                )

                                onSave(newAssignment)
                            }
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Save Assignment")
                }
            }
        }
    }
}
