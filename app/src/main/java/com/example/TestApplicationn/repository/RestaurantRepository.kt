package com.example.TestApplicationn.repository

import androidx.room.withTransaction
import com.example.TestApplicationn.db.ResturantDatabase
import com.example.TestApplicationn.network.NetworkApi
import com.example.TestApplicationn.utilities.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: NetworkApi,
    private val db: ResturantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllResturants()
        },
        fetch = {
            delay(2000)
            api.getAllData()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.intersetData(restaurants)
            }
        }
    )
}