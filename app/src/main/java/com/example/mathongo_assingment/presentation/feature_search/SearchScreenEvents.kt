package com.example.mathongo_assingment.presentation.feature_search

import androidx.compose.ui.text.input.TextFieldValue


sealed class SearchScreenEvents {
data class onquerychanged(val query:TextFieldValue): SearchScreenEvents()

object onbackbuttonclicked: SearchScreenEvents()
object onclearclicked: SearchScreenEvents()
data class onrecipeclicked(val id:Int): SearchScreenEvents()
}