package com.example.mathongo_assingment.presentation.feature_search

import android.util.Log
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.presentation.feature_search.components.BottomSheetContent
import com.example.mathongo_assingment.presentation.feature_search.components.SearchBar

import com.example.mathongo_assingment.ui.theme.boldtitle
import kotlinx.coroutines.launch
import okhttp3.internal.notify

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun Search_Screen(
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    viewmodel: SearchScreenViewmodel = hiltViewModel()
) {

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true, confirmValueChange = {
        if (it == SheetValue.Hidden && viewmodel.searchresult.value.sheetenabled) scope.launch { viewmodel.searchresult.value=  viewmodel.searchresult.value.copy(sheetenabled = false) }
        true
    })

    Scaffold(modifier = Modifier,

        topBar = {
            appbar(
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope
            )
        },

        content = { Search_Screen_Content(Modifier.padding(it),viewmodel)

            if (viewmodel.searchresult.value.sheetenabled && viewmodel.searchresult.value.clickedrecipe != null) {
                BottomSheetContent(modifier = Modifier,state=sheetState, ondismiss = {viewmodel.searchresult.value=  viewmodel.searchresult.value.copy(sheetenabled = false)}, recipe = viewmodel.searchresult.value.clickedrecipe!!)
            }}
    )


}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun appbar(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    viewmodel: SearchScreenViewmodel = hiltViewModel()
) {
    val state = viewmodel.searchresult.value
    with(sharedTransitionScope) {
        SearchBar(
            modifier = modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState(key = "search_screen"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .fillMaxWidth(),
            query = state.query,
            onValueChange = { viewmodel.action(SearchScreenEvents.onquerychanged(it)) },
            onbackarrowclicked = { viewmodel.action(SearchScreenEvents.onbackbuttonclicked) },
            onclearclicked = { viewmodel.action(SearchScreenEvents.onclearclicked) })
    }
}

@Composable
fun Search_Screen_Content(modifier: Modifier = Modifier, viewmodel: SearchScreenViewmodel) {
    val state = viewmodel.searchresult.value
    LazyColumn(modifier, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        items(state.result) {

                result ->

            var anotatedstring: AnnotatedString = buildAnnotatedString {
                var anotated = result.title
                if (result.title.lowercase().indexOf(state.query.text.lowercase(), 0, true) != -1) {

                    val startindex = result.title.lowercase()
                        .indexOf(state.query.text.lowercase(), startIndex = 0)
                    println(startindex)
                    val endindex = startindex + state.query.text.length
                    append(anotated.trim())
                    addStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Red
                        ), start = startindex, end = endindex
                    )
                } else {
                    append(anotated.trim())
                }
            }
            Row(modifier = Modifier.fillMaxWidth()
                .clickable { viewmodel.action(SearchScreenEvents.onrecipeclicked(result.id)) }, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_fastfood),
                    contentDescription = ""
                )
                Text(text = anotatedstring, maxLines = 1, modifier = Modifier.padding(start = 10.dp))

            }


            Log.d("search", anotatedstring.text)


        }
    }
}