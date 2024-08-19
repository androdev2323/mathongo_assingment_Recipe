package com.example.mathongo_assingment.presentation.feature_RecipeDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.domain.model.ExtendedIngredient
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Basicdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.ExpandedToolbar
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Ingreidemtsdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.TextContent
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.collapsedToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetail_Screem(viewmodel: RecipeDetailViewmodel = hiltViewModel()) {
    Recipe_screen(viewmodel.Recipe.value!!.extendedIngredients)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipe_screen(list: List<ExtendedIngredient>? = null) {
    var textview1 = remember {
        mutableStateOf(false)
    }
    var textview3 = remember {
        mutableStateOf(false)
    }
    val liststate = rememberLazyListState()
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val isCollapsed: Boolean by remember {
        derivedStateOf {
            scrollBehavior.state.collapsedFraction == 1f
        }
    }
    Scaffold(
        topBar = {
            /* Box(modifier = Modifier.fillMaxWidth()) {

        }

        */
        }
    ) {
        Column {


            Basicdetails(
                modifier = Modifier.padding(it),
                readyin = "1",
                servings = "2",
                price = "1"
            )
            Spacer(modifier = Modifier.height(16.dp))
            /*    LazyRow() {
            items(list!!) {
                Ingreidemtsdetails(it.image, it.name)
            }
        } */
            Spacer(modifier = Modifier.height(16.dp))

            TextContent(title = R.string.Quick_Summary, Content ="" , isexpanded = true) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            TextContent(
                title = R.string.Details_goodforhealth,
                Content = "lorem ipsum",
                isexpanded = textview1.value,
                onexpand = {textview1.value = !textview1.value}

            )

            Spacer(modifier = Modifier.height(16.dp))
            TextContent(
                title = R.string.Details_badforhealth,
                Content = "lorem ipsum",
                isexpanded = textview3.value,
                onexpand = {textview3.value = !textview3.value}

            )

        }

    }
}


@Preview
@Composable
private fun RecipeDetilpreview() {
    Recipe_screen(list = null)
}