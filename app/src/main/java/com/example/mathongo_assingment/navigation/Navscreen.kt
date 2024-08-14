package com.example.mathongo_assingment.navigation

sealed class Navscreen(val routes:String){

    object Homescreen:Navscreen("home_screen")
    object Searchscreen:Navscreen("search_screen")
    object DetailScreen:Navscreen(routes = "detail_screen")
}
