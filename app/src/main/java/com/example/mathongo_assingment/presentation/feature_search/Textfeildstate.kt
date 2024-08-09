package com.example.mathongo_assingment.presentation.feature_search

import androidx.compose.ui.text.input.TextFieldValue
import com.example.mathongo_assingment.domain.model.SearchRecipe.Result

data class Textfeildstate(
    val query:TextFieldValue = TextFieldValue(),
    val result:List<Result> = emptyList()
)