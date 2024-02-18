package com.example.yourlicey28.data.repository

import com.example.yourlicey28.data.remote.dto.ImagesApi
import com.example.yourlicey28.data.remote.dto.toImageDataDetail
import com.example.yourlicey28.domain.model.ImageDataDetails
import com.example.yourlicey28.domain.repository.RepositoryTask

class RepositoryImplTask(private val api: ImagesApi) : RepositoryTask {
    override suspend fun getImages(): List<ImageDataDetails> {
        val response = api.getImages(page = 1, limit = 100)
        val imagesList = mutableListOf<ImageDataDetails>()
        response.forEach {
            imagesList.add( it.toImageDataDetail()
//                ImageDataDetails(
//                    id = it.id,
//                    author = it.author,
//                    url = it.url,
//                    width = it.width,
//                    height = it.height
//                )
            )
        }
        return imagesList.toList()
    }

    override suspend fun getImage(id: Int): ImageDataDetails {
        val response = api.getImage(id = id) //ImageDetailsDto
//        val imageDataDetails = ImageDataDetails(
//            id = response.id,
//            author = response.author,
//            url = response.url,
//            width = response.width,
//            height = response.height
//        )
        return response.toImageDataDetail()
    }


}