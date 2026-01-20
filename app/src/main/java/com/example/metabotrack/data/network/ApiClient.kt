package com.example.metabotrack.data.network

object ApiClient {
    private const val BASE_URL = "https://api.calorieninjas.com/v1/calories?query=<activity>"

    val apiService: ActivityApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ActivityApiService::class.java)
    }
}