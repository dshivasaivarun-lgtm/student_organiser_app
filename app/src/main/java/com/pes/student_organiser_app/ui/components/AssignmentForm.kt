
package com.pes.student_organiser_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AssignmentForm(
    title: String,
    course: String,
    dueDate: String,
    priority: String,
    description: String,
    reminder: Boolean,
    onTitleChange: (String) -> Unit,
    onCourseChange: (String) -> Unit,
    onDueDateChange: (String) -> Unit,
    onPriorityChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onReminderChange: (Boolean) -> Unit
) {
    Column {
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Assignment Title *") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = course,
            onValueChange = onCourseChange,
            label = { Text("Course Name / Code *") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = dueDate,
            onValueChange = onDueDateChange,
            label = { Text("Due Date *") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Priority Level")

        Row(verticalAlignment = Alignment.CenterVertically) {
            listOf("Low", "Medium", "High").forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = priority == option,
                        onClick = { onPriorityChange(option) }
                    )
                    Text(option)
                }
            }
        }

        OutlinedTextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = { Text("Description / Notes") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = reminder,
                onCheckedChange = onReminderChange
            )
            Text("Enable Reminder Notification")
        }
    }
}
