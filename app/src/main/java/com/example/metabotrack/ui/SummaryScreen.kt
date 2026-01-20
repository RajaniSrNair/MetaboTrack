package com.example.metabotrack.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.metabotrack.data.ActivityViewModel

@Composable
fun SummaryScreen(viewModel: ActivityViewModel) {
    val activities = viewModel.activities.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(activities.value) { activity ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Activity: ${activity.name}")
                    Text("Duration: ${activity.durationMinutes} min")
                    Text("Calories: ${String.format("%.2f", activity.calories)} kcal")
                }
            }
        }
    }
}
