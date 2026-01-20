package com.example.metabotrack.data.network


import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers

interface CalorieApiService {

    @Headers("X-Api-Key: 1xs165KK14r812Bji5QVgA==dYmLksoLuKiOHyV")
    @GET("calories")
    suspend fun getCalories(@Query("query") activity: String): CalorieApiResponse

    companion object {
        fun create(): CalorieApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.calorieninjas.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CalorieApiService::class.java)
        }
    }
}
