package com.example.mathongo_assingment.presentation.feature_RecipeDetail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathongo_assingment.domain.Usecase.UseCase
import com.example.mathongo_assingment.domain.model.ExtendedIngredient
import com.example.mathongo_assingment.domain.model.Ingredient
import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewmodel @Inject constructor(private val useCase: UseCase,savedStateHandle: SavedStateHandle):ViewModel(){
 private var _Recipe:MutableState<Recipe?> = mutableStateOf(null)
    val Recipe:State<Recipe?> = _Recipe
    private var _Ingredients:MutableState<List<ExtendedIngredient?>> = mutableStateOf(emptyList())
    val Ingredients=_Ingredients
    private val id:Int = checkNotNull(savedStateHandle["id"])

init {

    getproductbyid(id)
}


    fun getproductbyid(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.Recipedetailusecase(id).collect(){
                when(it){
                    is NetworkResponse.Error -> Unit
                    is NetworkResponse.Loading -> Unit
                    is NetworkResponse.Success -> {
                         _Recipe.value = it.data

                        _Ingredients.value=it.data.extendedIngredients

                    }
                }
            }
        }
    }
}

