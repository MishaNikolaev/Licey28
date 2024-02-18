package com.example.yourlicey28.presentation.images

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourlicey28.domain.repository.RepositoryTask
import kotlinx.coroutines.launch

class ImagesViewModel(private val repository: RepositoryTask) : ViewModel() {
    private val _state = mutableStateOf(ImagesState())
    val state: State<ImagesState> = _state

    fun processEvent(event: ImagesEvent) {
        when (event) {
            is ImagesEvent.GetImages -> getImages()
        }
    }


    private fun getImages() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val images = repository.getImages(page = _state.value.page)
//            Если переменная Images не возвращает ничего , то есть ее размер = 0, то меняет endIsReached на True
//            Иначе увеличиваем page на 1 и также добавляем полученный лист images к существующему списку из стейта
            if (images.isEmpty()){
                _state.value = _state.value.copy(endIsReached = true)
            }
            else{
//                imagesList = [] (хранится в state)
//                images = [....]
                val imagesList = _state.value.imagesList + images
                _state.value = _state.value.copy(page = _state.value.page + 1, imagesList = imagesList)
            }
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}