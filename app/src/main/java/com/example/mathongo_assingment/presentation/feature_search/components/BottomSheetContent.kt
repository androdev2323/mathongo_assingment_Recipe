package com.example.mathongo_assingment.presentation.feature_search.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.Basicdetails
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(modifier: Modifier = Modifier, state: SheetState, ondismiss: () -> Unit) {
    ModalBottomSheet(onDismissRequest = { ondismiss() }, sheetState = state) {
        var states by remember {
            mutableStateOf(ContentState.BasicDetails)
        }

        LazyColumn(modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Title of Recipe")
                    IconButton({}) {
                        Icon(Icons.Filled.Favorite, "favourite icon")
                    }
                }
            }

            item {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
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
                        Text("Ingridients", color = MaterialTheme.colorScheme.onSurface)

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
                        Text("Full Recipe", color = MaterialTheme.colorScheme.onSurface)

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