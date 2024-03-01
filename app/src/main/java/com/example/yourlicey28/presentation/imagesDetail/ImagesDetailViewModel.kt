package com.example.yourlicey28.presentation.imagesDetail
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor (
    private val repository: RepositoryTask,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    init{
        val id = savedStateHandle.get<Int>("id")
        processEvent(event = UserDetailEvent.GetUser(id=id!!))
    }

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