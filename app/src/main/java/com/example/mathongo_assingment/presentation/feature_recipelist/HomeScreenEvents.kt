package com.example.mathongo_assingment.presentation.feature_recipelist

sealed class HomeScreenEvents {
    object searchclicked:HomeScreenEvents()
    data class onitemclicked(val id:Int):HomeScreenEvents()
}