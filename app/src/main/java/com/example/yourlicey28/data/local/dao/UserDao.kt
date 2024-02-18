package com.example.yourlicey28.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yourlicey28.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity") // извлекает все записи из таблицы
    fun getAll(): List<UserEntity>

    @Insert // Запрос для добавления списка
    fun insertAll(users: List<UserEntity>)

    @Insert // Запрос для добавления
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Update
    fun update(user: UserEntity)
}