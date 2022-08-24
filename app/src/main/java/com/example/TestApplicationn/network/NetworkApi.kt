package com.example.TestApplicationn.network

import androidx.lifecycle.LiveData
import com.example.TestApplicationn.pojo.Restaurant
import retrofit2.http.GET

interface NetworkApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getAllData(): List<Restaurant>
}