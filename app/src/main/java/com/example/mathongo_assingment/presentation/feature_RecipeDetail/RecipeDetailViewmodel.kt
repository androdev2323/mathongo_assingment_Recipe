package com.example.mathongo_assingment.presentation.feature_RecipeDetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathongo_assingment.domain.Usecase.UseCase
import com.example.mathongo_assingment.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewmodel @Inject constructor(private val useCase: UseCase,savedStateHandle: SavedStateHandle):ViewModel(){
    private var _Recipe:MutableState<Recipe?> = mutableStateOf(null)
    val Recipe=_Recipe
    private val id:Int = checkNotNull(savedStateHandle["id"])

init {

    getproductbyid(id)
}


    fun getproductbyid(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.Recipedetailusecase(id)
        }
    }
}

