package com.example.mathongo_assingment.data

import android.util.Log

import com.example.mathongo_assingment.domain.model.RecipeResponse
import com.example.mathongo_assingment.domain.model.SearchRecipe.searchresponse
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.domain.repository.recipeAPi
import com.example.mathongo_assingment.util.NetworkResponse
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class reciperepoImpl @Inject constructor(
    private val recipeAPi: recipeAPi
):reciperepo {
    override suspend fun getrandomrecipe(id: Int): Flow<NetworkResponse<RecipeResponse>> = flow {
        emit(NetworkResponse.Loading())

          val response = recipeAPi.getrandom(number = id)
          if (response.isSuccessful && response.body() != null ) {
              Log.d("API", response.body()!!.recipes[0].aggregateLikes.toString())
               response.body()?.let {
                   emit(NetworkResponse.Success(it))

               }

          } else {

              emit(NetworkResponse.Error(response.message()))
          }




    }

    override suspend fun searchrecipe(query: String): Flow<NetworkResponse<searchresponse>> = flow {
        emit(NetworkResponse.Loading())
        Log.d("api",query)
        val response=recipeAPi.searchrecipe(query = query)

        if(response.isSuccessful && response.body() != null){
             Log.d("api",response.body()!!.totalResults.toString())
            emit(NetworkResponse.Success(response.body()!!))
        }
        else{
            emit(NetworkResponse.Error(response.message()))
        }
    }
}