package com.example.metabotrack.data.repository.

import kotlinx.coroutines.flow.Flow

class ActivityRepository(private val dao: ActivityDao) {

    fun getAllActivities(): Flow<List<ActivityEntity>> = dao.getAllActivities()

    suspend fun insertActivity(activity: ActivityEntity) {
        dao.insertActivity(activity)
    }
}
