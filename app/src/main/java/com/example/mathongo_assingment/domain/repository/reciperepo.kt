package com.example.mathongo_assingment.domain.repository


import com.example.mathongo_assingment.domain.model.RecipeResponse
import com.example.mathongo_assingment.domain.model.SearchRecipe.searchresponse
import com.example.mathongo_assingment.util.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface reciperepo  {
    suspend fun getrandomrecipe(id:Int): Flow<NetworkResponse<RecipeResponse>>
    suspend fun searchrecipe(query:String):Flow<NetworkResponse<searchresponse>>
}