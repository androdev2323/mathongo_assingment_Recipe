package com.example.mathongo_assingment.presentation.feature_search

import androidx.compose.ui.text.input.TextFieldValue
import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.domain.model.SearchRecipe.Result

data class Textfeildstate(
    val query: TextFieldValue = TextFieldValue(),
    val result: List<Result> = listOf(
        Result(
            id = 654959,
            title = "Pasta With Tuna",
            image = "https://example.com/image1.jpg", // Placeholder URL
            imageType = "jpg"
        ),
        Result(
            id = 554145,
            title = "A Very Long and Descriptive Title for a Gourmet Grilled Cheese Sandwich with Tomato Soup",
            image = "https://example.com/image2.jpg", // Placeholder URL
            imageType = "jpg"
        ),
        Result(
            id = 654857,
            title = "Pasta and Seafood",
            image = "https://example.com/image3.jpg", // Placeholder URL
            imageType = "jpg"
        ),
        Result(
            id = 654883,
            title = "Pasta e Fagioli",
            image = "https://example.com/image4.jpg", // Placeholder URL
            imageType = "jpg"
        ),
        Result(
            id = 654926,
            title = "Pasta With Gorgonzola",
            image = "https://example.com/image5.jpg", // Placeholder URL
            imageType = "jpg"
        ),
        Result(
            id = 654944,
            title = "Pasta With Salmon",
            image = "https://example.com/image6.jpg", // Placeholder URL
            imageType = "jpg"
        )
    ),
    val sheetenabled: Boolean = false,
    val clickedrecipe: Recipe? = null

)