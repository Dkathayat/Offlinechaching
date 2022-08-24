package com.example.TestApplicationn.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.TestApplicationn.pojo.Restaurant


@Database(entities = [Restaurant::class], version = 1)
abstract class ResturantDatabase: RoomDatabase() {

    abstract fun restaurantDao(): RoomDao

}