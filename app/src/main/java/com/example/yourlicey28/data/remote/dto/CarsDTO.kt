package com.example.yourlicey28.data.remote.dto

import com.example.yourlicey28.data.local.entity.CarEntity
import com.example.yourlicey28.domain.model.CarDataDetails
import com.google.gson.annotations.SerializedName


data class CarsAllDto(
    val cars: List<CarsDataDetailsDto>,
    val skip:Int,
    val limit:Int
)

data class CarsDataDetailsDto(
    val mark: String,
    val model: String,
    val id: Int,
    val description: String,
    @SerializedName("card_photo")
    val cardPhoto: String

//    val card_photo:String
)

fun CarsDataDetailsDto.toCarDataDetail(): CarDataDetails {
    return CarDataDetails(id = id, mark = mark, model = model, description = description, cardPhoto = cardPhoto)
}

fun CarsDataDetailsDto.toCarEntity(): CarEntity {
    return CarEntity(id = id, mark = mark, model = model, description = description, cardPhoto = cardPhoto)
}

