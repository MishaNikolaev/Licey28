package com.example.yourlicey28.data.remote.dto

data class RickMorty(
    val info:Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String,
)

data class Result(
    val id: Int,
    val name: String,
    val gender: String,
    val image: String
)