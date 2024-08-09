package com.example.mathongo_assingment.domain.model

data class Step(
    val equipment: List<Equipment>,
    val ingredients: List<Ingredient>,

    val number: Int,
    val step: String
)