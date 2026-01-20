package com.example.metabotrack.data.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.metabotrack.data.db.ActivityEntity
import com.example.metabotrack.viewmodel.ActivityViewModel

@Composable
fun ActivityInputScreen(
    navController: NavController,
    viewModel: ActivityViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Log Activity", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Activity Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("Duration (minutes)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            // Launch coroutine
            coroutineScope.launch {
                val calories = viewModel.getCaloriesFromApi(activityName)
                viewModel.addActivity(
                    ActivityEntity(
                        name = activityName,
                        durationMinutes = duration.toDouble(),
                        intensity = intensity,
                        caloriesBurned = calories
                    )
                )
                onViewSummary()
            }
        }) {
            Text("Add Activity")
        }


        if (calories.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Calories burned: $calories kcal")
        }
    }
}
