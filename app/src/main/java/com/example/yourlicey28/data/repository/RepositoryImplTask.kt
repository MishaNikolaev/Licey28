package com.example.yourlicey28.data.repository

import android.util.Log
import com.example.yourlicey28.data.local.AppDatabase
import com.example.yourlicey28.data.local.entity.toUser
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.toUserEntity
import com.example.yourlicey28.domain.repository.RepositoryTask

private const val TAG = "RepositoryImplTask"
class RepositoryImplTask(private val db: AppDatabase) : RepositoryTask {
    override suspend fun getUsers(): List<User> {
        val userEntities = db.userDao().getAll()
        val users = userEntities.map {
            it.toUser()
        }
        return users
    }

    override suspend fun getUser(id: Int): User {
        TODO("Not yet implemented")
    }

    override suspend fun insert(user: User) {
        val userEntity = db.userDao().insert(user.toUserEntity())
    }

    override suspend fun update(user: User) {
        val userEntity = db.userDao().update(user.toUserEntity())
    }

    override suspend fun delete(user: User) {
        val userEntity = db.userDao().delete(user.toUserEntity())
    }


}