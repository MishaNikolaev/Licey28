package com.example.yourlicey28.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.yourlicey28.domain.model.CarDataDetails

@Entity
data class CarEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val mark: String,
    val model: String,
    val description: String,
    val cardPhoto: String
)

fun CarEntity.toCarDataDetails(): CarDataDetails {
    return CarDataDetails(
        id = id,
        mark = mark,
        model = model,
        description = description,
        cardPhoto = cardPhoto
    )
}