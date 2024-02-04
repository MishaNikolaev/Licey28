package com.example.yourlicey28.data.repository

import com.example.yourlicey28.R
import com.example.yourlicey28.data.remote.RickMortyApi
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.model.UserDetails
import com.example.yourlicey28.domain.repository.Repository

class RepositoryImpl(private val api: RickMortyApi) : Repository {
    override suspend fun addUsers(): List<User> {
        val response = api.getCharachters(page = 1)
        val usersList = mutableListOf<User>()

        response.results.forEach {
            usersList.add(
                User(
                    name = it.name,
                    image = it.image,
                    gender = it.gender,
                    id = it.id
                )
            )
        }

        return usersList.toList()
    }

    override suspend fun getUser(id: Int): UserDetails {
        val response = api.getCharacter(id = id)

        return response
    }

}