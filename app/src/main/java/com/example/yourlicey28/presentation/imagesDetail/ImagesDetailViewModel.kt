package com.example.yourlicey28.presentation.imagesDetail
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryTask
import kotlinx.coroutines.launch
class UserDetailViewModel(private val repository: RepositoryTask) : ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    fun processEvent(event: UserDetailEvent) {
        when (event) {
            is UserDetailEvent.GetUser -> getImage(id = event.id)
        }
    }


    private fun getImage(id: Int) {
        viewModelScope.launch {
            val userDetail = repository.getUser(id = id)
            _state.value = _state.value.copy(userDetail = userDetail)
        }
    }
}