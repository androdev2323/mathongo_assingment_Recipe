package com.example.mathongo_assingment.presentation.feature_RecipeDetail.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.ui.theme.boldtitle
import com.example.mathongo_assingment.util.Constant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedToolbar(
    scrollBehavior: TopAppBarScrollBehavior,

){


    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .height(Constant.EXPANDED_TOP_BAR_HEIGHT),
        contentAlignment = Alignment.BottomStart
        ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Text(text = "Experimental toolbar", color = MaterialTheme.colorScheme.onPrimary, style = boldtitle)
    }

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun collapsedToolbar(
    scrollBehavior: TopAppBarScrollBehavior,
    iscollapsed:Boolean
){
    val color: Color by animateColorAsState(if(iscollapsed) MaterialTheme.colorScheme.background else Color.Transparent)
     Box(
         Modifier
             .background(color)
             .fillMaxWidth()
             .height(Constant.COLLAPSED_TOP_BAR_HEIGHT)
             .padding(16.dp),
         contentAlignment = Alignment.BottomStart){
       AnimatedVisibility(visible = iscollapsed) {
           Text(text = "Experiment toolbaar", style = boldtitle)
       }
     }
}


