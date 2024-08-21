package com.example.mathongo_assingment.presentation.feature_recipelist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathongo_assingment.data.reciperepoImpl
import com.example.mathongo_assingment.domain.Usecase.UseCase
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val reciperepo: reciperepoImpl):ViewModel() {
private val _getrandomrecipe= mutableStateOf(HomeScreenState())
    val getrandomrecipe: State<HomeScreenState> = _getrandomrecipe
    private var getrandomrecipeJob: Job? = null
 init {
     getrandomrecipe(15)
 }

    fun getrandomrecipe(id:Int) {
        viewModelScope.launch {
            reciperepo.getrandomrecipe(id).collect {networkresponse ->

                when(networkresponse){
                    is NetworkResponse.Error ->  Log.d("viewmodel",networkresponse.error!!)
                    is NetworkResponse.Loading -> Log.d("viewmodel","loading")
                    is NetworkResponse.Success -> {

                             _getrandomrecipe.value=_getrandomrecipe.value.copy(
                                 randomlist = networkresponse.data.recipes
                             )


                    }
                }
            }
        }
    }

}