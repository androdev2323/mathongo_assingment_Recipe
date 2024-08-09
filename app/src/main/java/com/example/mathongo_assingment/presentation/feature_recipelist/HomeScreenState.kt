package com.example.mathongo_assingment.presentation.feature_recipelist

import com.example.mathongo_assingment.domain.model.Recipe

data class HomeScreenState(
    val randomlist:List<Recipe> = emptyList(),

    val allRecipelist:List<Recipe> = emptyList()
)
