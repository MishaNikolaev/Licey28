package com.example.yourlicey28.presentation.images

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.model.User
import com.example.yourlicey28.domain.repository.RepositoryTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: RepositoryTask) : ViewModel() {
    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    init {
        processEvent(UserEvent.GetUsers)
    }

    fun processEvent(event: UserEvent) {
        when (event) {
            is UserEvent.GetUsers -> getUsers()
            is UserEvent.AddUser -> addUser()
            is UserEvent.RemoveUser -> removeUser(event.user)
            is UserEvent.UpdateUser -> updateUser(event.user)
        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            val usersList = repository.getUsers()
            _state.value = _state.value.copy(usersList = usersList)
        }
    }

    private fun addUser() {
        viewModelScope.launch {
            // 1 , 2
            val id = Random.nextInt(0, 100)
            val name = generateRandomString(10)
            val user = User(id = id, name = name)
            repository.insert(user = user) // 1 , 2 , 3

            val usersList = repository.getUsers()
            _state.value = _state.value.copy(usersList = usersList)
        }
    }

    private fun removeUser(user: User) {
        viewModelScope.launch {
            repository.delete(user = user)
            val userList = repository.getUsers()
            _state.value = state.value.copy(usersList = userList)
        }
    }

    private fun updateUser(user: User) {
        viewModelScope.launch {
            val updatedUser = user.copy(name = generateRandomString(5))
            repository.update(user = updatedUser)
            val updatedAllUsers = repository.getUsers()
            _state.value = state.value.copy(usersList = updatedAllUsers)
        }
    }

    fun generateRandomString(length: Int): String {
        val charPool: List<Char> =
            ('a'..'z') + ('A'..'Z') + ('0'..'9') // Диапазон символов для генерации случайной строки
        return (1..length)
            .map { Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

}