package com.example.mathongo_assingment.presentation.feature_search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathongo_assingment.domain.Usecase.UseCase
import com.example.mathongo_assingment.util.NetworkResponse

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewmodel @Inject constructor(private val usecase:UseCase ):ViewModel(){
    private var prevquery=""
    private val _Searchresult= mutableStateOf(Textfeildstate())
     val searchresult= _Searchresult

    init {
        
    }
fun action(events: SearchScreenEvents){
    when(events){
       is  SearchScreenEvents.onbackbuttonclicked -> {}
       is SearchScreenEvents.onclearclicked -> {_Searchresult.value=_Searchresult.value.copy(query = TextFieldValue())}
        is SearchScreenEvents.onquerychanged -> {
            if (prevquery.isBlank()) {
                if (events.query.text.trim().isNotBlank()) {
                    _Searchresult.value = _Searchresult.value.copy(query = events.query)
                    search(searchresult.value.query.text.toString())
                    prevquery = events.query.text.trim()
                } else if(events.query.text.isBlank()) {
                    _Searchresult.value = _Searchresult.value.copy(
                        query = TextFieldValue(),
                        result = emptyList()
                    )

                }
            }
            else{
                if(events.query.text.isNotBlank()) {
                    if (prevquery.equals(events.query.text.trim()) == false) {
                        _Searchresult.value = _Searchresult.value.copy(query = events.query)
                        search(searchresult.value.query.text.toString())
                        prevquery = events.query.text.trim()
                    }
                }
                else{
                    _Searchresult.value = _Searchresult.value.copy(
                        query = TextFieldValue(),
                        result = emptyList()
                    )
                    prevquery=""
                }


            }
        }
        is SearchScreenEvents.onrecipeclicked -> {}
    }
}
fun search(query:String){
    viewModelScope.launch {
        usecase.searchRecipeUsecase(query).collect(){NetworkResponse->
            when(NetworkResponse){
                is NetworkResponse.Error -> Unit
                is NetworkResponse.Loading -> Unit
                is NetworkResponse.Success -> {

                     _Searchresult.value=_Searchresult.value.copy(
                         result =  NetworkResponse.data.results
                     )
                 }
             }

                }
            }

        }


    }

