package com.example.mathongo_assingment.domain.repository

import com.example.mathongo_assingment.BuildConfig
import com.example.mathongo_assingment.domain.model.Recipe

import com.example.mathongo_assingment.domain.model.RecipeResponse
import com.example.mathongo_assingment.domain.model.SearchRecipe.searchresponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface recipeAPi {
    @GET("recipes/random")
    suspend fun getrandom(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("number") number: Int = 25,
    ): Response<RecipeResponse>

    @GET("recipes/{id}/information")
    suspend fun getrecipeinfo(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY


        ): Response<Recipe>

    @GET("recipes/complexSearch/")
    suspend fun searchrecipe(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("query") query:String
    ):Response<searchresponse>
}

