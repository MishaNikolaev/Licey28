package com.example.yourlicey28.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.yourlicey28.data.local.entity.CarEntity

@Dao
interface CarsDao {
    @Query("SELECT * FROM carentity") // извлекает все записи из таблицы
    suspend fun getAll(): List<CarEntity>

    @Query("SELECT * FROM carentity WHERE id=:id")
    suspend fun getById(id: Int): CarEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления списка
    suspend fun insertAll(cars: List<CarEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Запрос для добавления
    suspend fun insert(car: CarEntity)

    @Delete
    suspend fun delete(car: CarEntity)

    @Update
    suspend fun update(car: CarEntity)
}
