package com.example.mathongo_assingment.domain.model.SearchRecipe

data class searchresponse(
    val results: List<Result>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)

data class Result(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)