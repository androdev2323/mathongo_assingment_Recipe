package com.example.mathongo_assingment.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathongo_assingment.presentation.feature_recipelist.HomeScreen
import com.example.mathongo_assingment.presentation.feature_search.Search_Screen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Apphost(){
    SharedTransitionLayout(modifier = Modifier.fillMaxSize()){

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Navscreen.Homescreen.routes) {
                composable(Navscreen.Homescreen.routes) {


                    HomeScreen(navController, sharedTransitionscope = this@SharedTransitionLayout, animatedVisibilityScope = this@composable)
                }
                composable(Navscreen.Searchscreen.routes) {
                    Search_Screen(animatedVisibilityScope = this@composable, sharedTransitionScope = this@SharedTransitionLayout)
                }
            }

    }
}