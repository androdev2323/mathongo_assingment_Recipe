package com.example.mathongo_assingment.presentation.feature_recipelist

import android.util.Log
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.navigation.Navscreen
import com.example.mathongo_assingment.presentation.feature_recipelist.components.VerticalCard
import com.example.mathongo_assingment.presentation.feature_recipelist.components.horizontalcard
import com.example.mathongo_assingment.ui.theme.boldtitle


@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(navController: NavController,sharedTransitionscope: SharedTransitionScope, animatedVisibilityScope: AnimatedContentScope){

    Scaffold {
       homeScreen(Modifier.padding(it),navController,sharedTransitionscope,animatedVisibilityScope)
    }
}
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun homeScreen(modifier: Modifier=Modifier, navController: NavController, sharedTransitionscope: SharedTransitionScope, animatedVisibilityScope: AnimatedContentScope,viewModel: HomeScreenViewModel = hiltViewModel()) {
    val state=viewModel.getrandomrecipe.value
  Column(modifier.padding(8.dp)){

          Text(text = stringResource(id = R.string.Welcome_text,"Ganesh"), style = MaterialTheme.typography.headlineSmall)
          Text(text = stringResource(id = R.string.Welcome_message), style = TextStyle(fontSize = 13.sp))

           Spacer(modifier.height(16.dp) )
      with(sharedTransitionscope) {
          Box(
              modifier
                  .fillMaxWidth()
                  .background(
                      shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                      color = MaterialTheme.colorScheme.surfaceVariant
                  )

                  .sharedBounds(rememberSharedContentState(key = "search_bar"),
                      animatedVisibilityScope = animatedVisibilityScope)
                  .clickable { navController.navigate(Navscreen.Searchscreen.routes) }
          ) {

              Row(
                  modifier
                      .fillMaxWidth()
                      .padding(14.dp)
              ) {
                  Icon(
                      imageVector = Icons.Default.Search,
                      contentDescription = null,
                      modifier.padding(end = 4.dp)
                  )
                  Text(text = stringResource(id = R.string.Search_hint))

              }
          }
      }
      Spacer(modifier = modifier.height(25.dp))
      Text(text = stringResource(id = R.string.Popular_recipe), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))
      Spacer(modifier = modifier.height(12.dp))
      LazyRow(
          modifier
              .padding(top = 2.dp)
              .defaultMinSize(minHeight = 200.dp),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
              ){
         items(state.randomlist){
             Log.d("viewmodel123",it.image.toString())
             horizontalcard(recipe = it)
         }
      }
      Spacer(modifier = modifier.height(15.dp))
      Text(text = stringResource(id = R.string.All_recipe), style = boldtitle)
      LazyColumn(modifier.padding(top = 5.dp), verticalArrangement = Arrangement.spacedBy(10.dp)){
             items(state.randomlist.reversed()){
                 VerticalCard(recipe = it)
             }
      }




  }
}

@Preview
@Composable
fun Homescreenprieview() {

}
