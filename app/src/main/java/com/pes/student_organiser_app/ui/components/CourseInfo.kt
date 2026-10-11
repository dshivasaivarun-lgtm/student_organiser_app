package com.pes.student_organiser_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.width
import androidx.compose.foundation.layout.width

@Composable
fun CourseInfo(
    courseName: String,
    courseCode: String,
    instructor: String,
    progress: Float
) {
    Card(
        modifier = Modifier
            .width(260.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(courseCode, style = MaterialTheme.typography.labelLarge)
            Text(courseName, style = MaterialTheme.typography.titleMedium)
            Text("Instructor: $instructor")

            Spacer(modifier = Modifier.height(8.dp))
            Text("Progress: ${(progress * 100).toInt()}%")

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}