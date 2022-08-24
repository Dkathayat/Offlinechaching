package com.example.TestApplicationn.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.TestApplicationn.pojo.Restaurant
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun intersetData(restaurant: List<Restaurant>)

    @Query("SELECT * FROM testres")
    fun getAllResturants(): Flow<List<Restaurant>>

    @Query("DELETE FROM testres")
    suspend fun deleteAllRestaurants()


}