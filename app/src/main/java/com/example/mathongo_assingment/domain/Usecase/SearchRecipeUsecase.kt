package com.example.mathongo_assingment.domain.Usecase

import com.example.mathongo_assingment.domain.model.SearchRecipe.searchresponse
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.util.NetworkResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipeUsecase @Inject constructor(val reciperepo: reciperepo){

    suspend operator fun invoke(query:String):Flow<NetworkResponse<searchresponse>>{
        return reciperepo.searchrecipe(query)
    }
}