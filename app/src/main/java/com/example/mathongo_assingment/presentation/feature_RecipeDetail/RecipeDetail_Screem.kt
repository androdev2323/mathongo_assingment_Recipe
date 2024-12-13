package com.example.mathongo_assingment.presentation.feature_RecipeDetail

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.domain.model.ExtendedIngredient
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Basicdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.ExpandedToolbar
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Ingreidemtsdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.TextContent

import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.collapsedToolbar
import com.example.mathongo_assingment.ui.theme.boldtitle
import com.example.mathongo_assingment.util.Constant
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetail_Screem(viewmodel: RecipeDetailViewmodel = hiltViewModel()) {

    val liststate = rememberCollapsingToolbarScaffoldState()
    val recipe = viewmodel.Recipe.value
    if (recipe != null) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = liststate,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = {


                val textSize = (18 + (30 - 18) * liststate.toolbarState.progress).sp
                Log.d("hu",textSize.value.toString())
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .height(Constant.EXPANDED_TOP_BAR_HEIGHT),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = recipe.image,
                            contentScale = ContentScale.Crop
                        ),
                        contentDescription = "",
                        alpha = if (textSize.value == 18f) 1f else 0f,
                        contentScale = ContentScale.Crop,

                        modifier = Modifier
                            .fillMaxSize()
                            .parallax(0.3f)

                    )
                    Text(

                        text = "Experimental toolbar",

                        color = MaterialTheme.colorScheme.onPrimary,
                        style = TextStyle(fontSize = textSize),
                        modifier = Modifier.road(
                            whenExpanded = Alignment.BottomStart,
                            whenCollapsed = Alignment.TopStart
                        )
                    )
                }
            },

        ){

                Column(Modifier.verticalScroll(rememberScrollState())) {


                    Basicdetails(
                        modifier = Modifier,
                        readyin = viewmodel.Recipe.value?.readyInMinutes.toString(),
                        servings = viewmodel.Recipe.value?.servings.toString(),
                        price = viewmodel.Recipe.value?.pricePerServing.toString()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow() {
                        items(viewmodel.Ingredients.value) {
                            if (it != null) {
                                Log.d("recipedetail", it.image)
                                Ingreidemtsdetails(it.image, it.name)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                   TextContent(
                        title = R.string.Quick_Summary,
                        Content = "Lorealipsum",
                        isexpanded = true,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextContent(
                        title = R.string.Details_goodforhealth,
                        Content = "lorem ipsum",
                        isexpanded = false,
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    TextContent(
                        title = R.string.Details_badforhealth,
                        Content = "Loren Loren Loren Loren Loren Loren Loren Loren Loren Loren",
                        isexpanded = false,


                        )


                }


        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipe_screen(list: List<ExtendedIngredient>? = null) {
}


@Preview
@Composable
private fun RecipeDetilpreview() {

}