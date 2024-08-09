package com.example.mathongo_assingment.util

sealed class NetworkResponse<out T>{

    data  class Success<T>(val data: T):NetworkResponse<T>()
    class Loading<T>():NetworkResponse<T>()
    data class Error<T>(val error: String):NetworkResponse<T>()


}