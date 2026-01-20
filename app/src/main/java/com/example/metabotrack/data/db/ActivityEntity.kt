package com.example.metabotrack.data.db

@Entity(tableName = "activities")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val met: Double,
    val durationMinutes: Int,
    val calories: Double,
    val timestamp: Long = System.currentTimeMillis()
)