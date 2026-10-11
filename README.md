# Student Organizer App

An Android student organizer application built with **Kotlin**, **Jetpack Compose**, and **Navigation Compose**.

## Student Details

- **Name:** Dharoor Shiva Sai Varun
- **SRN:** PES1UG24CS150
- **University:** PES University
- **Program:** B.Tech — Computer Science

## Project Overview

The Student Organizer App provides a simple interface for viewing courses and managing assignments. It uses sample data models and Compose UI state to represent the app's data.

## Features

- **Dashboard:** Displays a welcome message, course information, quick statistics, and pending assignments.
- **Assignments:** Displays assignments and supports filtering by all, pending, and completed.
- **Add Assignment:** Provides a form to enter assignment details and validates required fields before saving.
- **Profile:** Displays student information and an academic overview.
- **Settings:** Includes dark-mode and default-screen controls.
- **Reusable UI components:** Shared app bar, bottom navigation, course card, assignment card, profile section, and assignment form.

## Technologies Used

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Navigation Compose

## Data Handling

This project uses sample data models and in-memory Compose state. **Room Database persistence and network/API calls are not part of the assignment requirements.** Data may reset when the app process restarts.

## Project Structure

```text
app/src/main/java/com/pes/student_organiser_app/
├── MainActivity.kt
├── Models.kt
├── navigation/
│   └── Screen.kt
├── ui/
│   ├── components/
│   │   ├── AppBar.kt
│   │   ├── AssignmentCard.kt
│   │   ├── AssignmentForm.kt
│   │   ├── BottomBar.kt
│   │   ├── CourseInfo.kt
│   │   └── StudentProfile.kt
│   ├── screens/
│   │   ├── AddAssignmentScreen.kt
│   │   ├── AssignmentsScreen.kt
│   │   ├── DashboardScreen.kt
│   │   ├── ProfileScreen.kt
│   │   └── SettingsScreen.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
```

## Running the Project

1. Clone or download this repository.
2. Open the project in Android Studio.
3. Allow Gradle sync to complete.
4. Select an Android emulator or connected Android device.
5. Click **Run**.

## Notes

- Assignment and settings data are currently held in memory.
- The app is intended as an academic project demonstrating Compose UI, state, reusable components, callbacks, form validation, and navigation.

---

**Developed by Dharoor Shiva Sai Varun**  
**SRN:** PES1UG24CS150
