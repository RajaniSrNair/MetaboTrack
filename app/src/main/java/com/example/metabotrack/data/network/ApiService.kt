package com.example.metabotrack.data.network

import retrofit2.http.GET
import retrofit2.http.Query

data class ActivityResponse(
    val activity: String,
    val met: Double
)

interface ActivityApiService {
    // endpoint: https://api.calorieninjas.com/v1/calories?query=<activity>
    @GET("activity")
    suspend fun getActivityMet(@Query("name") activityName: String): ActivityResponse
}
