package com.example.mathongo_assingment.presentation.feature_search.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Basicdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Ingreidemtsdetails
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.TextContent
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    state: SheetState,
    ondismiss: () -> Unit,
    recipe: Recipe
) {
    ModalBottomSheet(onDismissRequest = { ondismiss() }, sheetState = state) {
        var states by remember {
            mutableStateOf(ContentState.BasicDetails)
        }

        LazyColumn(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = recipe.title, style = MaterialTheme.typography.titleLarge)
                    IconButton({}) {
                        Icon(Icons.Filled.Favorite, "favourite icon", tint = MaterialTheme.colorScheme.primaryContainer)
                    }
                }
            }

            item {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = recipe.image,
                        contentScale = ContentScale.Crop
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentDescription = "Image of Recipe"
                )
                Spacer(Modifier.height(16.dp))

                Basicdetails(modifier = modifier, servings = "17", readyin = "45", price = "50")
                if (states == ContentState.BasicDetails) {
                    ActionButton(
                        Title = "Get Ingredients",
                        onClicked = { states = ContentState.Ingredients })
                }
                HorizontalDivider(thickness = 1.dp, color = Color(0xFFEFF0F0))
            }


            item() {
                AnimatedVisibility(
                    states >= ContentState.Ingredients,
                    enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                    exit = fadeOut() + shrinkVertically(shrinkTowards = Alignment.Top)
                ) {

                    SectionalHeader(
                        text = "Ingredients",
                        isExpanded = states == ContentState.Ingredients,
                        onToggle = {
                            states = ContentState.Ingredients
                        },
                        onClick = { states = ContentState.Full_Recipe },
                        buttonTitle = "Get Full Recipe"
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(recipe.extendedIngredients) { ingredients ->
                                Ingreidemtsdetails(url = ingredients.image, text = ingredients.name)
                            }
                        }

                    }
                }

            }




            item() {
                AnimatedVisibility(
                    states >= ContentState.Full_Recipe,
                    enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                    exit = fadeOut() + shrinkVertically(shrinkTowards = Alignment.Top)
                ) {

                    SectionalHeader(
                        text = "Full Recipe",
                        isExpanded = states == ContentState.Full_Recipe,
                        onToggle = {
                            states = ContentState.Full_Recipe
                        },
                        onClick = { states = ContentState.SimillarRecipe },
                        buttonTitle = "Get Simillar Recipe"
                    ) {
                       Column {
                           TextContent(title = R.string.summary , Content = recipe.summary, isexpanded = true)
                           TextContent(title = R.string.Title_Instuctions , Content = recipe.instructions, isexpanded = true)
                       }

                    }
                }

            }
        }
    }
}


enum class ContentState {
    BasicDetails,
    Ingredients,
    Full_Recipe,
    SimillarRecipe

}