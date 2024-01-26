package com.example.yourlicey28.data.repository

import com.example.yourlicey28.R
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.repository.Repository

class RepositoryImpl: Repository {
    override fun addUsers(): List<User> {
        val listUser = mutableListOf<User>()
        repeat(10){
            val newUser = User(
                name = "User${(1..100).random()}", gender = "Gender:${(1..100).random()}",
                id = (1..100).random(), image = R.drawable.school_image
            )
            listUser.add(newUser)
        }
        return listUser.toList()
    }

}