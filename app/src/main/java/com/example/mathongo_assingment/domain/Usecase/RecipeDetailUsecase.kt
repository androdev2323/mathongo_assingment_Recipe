package com.example.mathongo_assingment.domain.Usecase

import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.util.NetworkResponse
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class RecipeDetailUsecase @Inject constructor(val reciperepo: reciperepo) {
    suspend operator fun invoke(id:Int): Flow<NetworkResponse<Recipe>> {
        return reciperepo.getrecipebyid(id = id)
    }
}