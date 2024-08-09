package com.example.mathongo_assingment.domain.Usecase


import android.util.Log
import com.example.mathongo_assingment.domain.model.RecipeResponse
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.util.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class randomrecipeUsecase @Inject constructor(
    private val reciperepo: reciperepo
) {
    suspend operator fun invoke(id:Int): Flow<NetworkResponse<RecipeResponse>> {
     val a= reciperepo.getrandomrecipe(id)
       a.collect() {
           when (it) {
               is NetworkResponse.Error -> Unit
               is NetworkResponse.Loading -> Unit
               is NetworkResponse.Success ->  Log.d("usecase",it.data!!.recipes.toString())
           }
       }
        return a
    }
}