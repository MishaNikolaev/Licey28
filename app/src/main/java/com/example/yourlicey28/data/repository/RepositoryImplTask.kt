package com.example.yourlicey28.data.repository

import android.util.Log
import com.example.yourlicey28.data.remote.ImagesApi
import com.example.yourlicey28.data.remote.dto.toImageDataDetail
import com.example.yourlicey28.domain.model.ImageDataDetails
import com.example.yourlicey28.domain.repository.RepositoryTask

private const val TAG = "RepositoryImplTask"
class RepositoryImplTask(private val api: ImagesApi) : RepositoryTask {
    override suspend fun getImages(page:Int): List<ImageDataDetails> {
        val response = api.getImages(page = page, limit = 20)
        Log.d(TAG, "getImages: $response")
        val imagesList = mutableListOf<ImageDataDetails>()
        response.forEach {
            imagesList.add( it.toImageDataDetail()
            )
        }
        return imagesList.toList()
    }

    override suspend fun getImage(id: Int): ImageDataDetails {
        val response = api.getImage(id = id)
        return response.toImageDataDetail()
    }
}