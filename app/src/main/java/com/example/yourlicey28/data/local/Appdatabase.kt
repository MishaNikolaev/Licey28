package com.example.yourlicey28.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yourlicey28.data.local.dao.CarsDao
import com.example.yourlicey28.data.local.entity.CarEntity

@Database(entities = [CarEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carsDao(): CarsDao
}