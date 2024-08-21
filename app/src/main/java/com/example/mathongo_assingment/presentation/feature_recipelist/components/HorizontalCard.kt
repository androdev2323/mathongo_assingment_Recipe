package com.example.mathongo_assingment.presentation.feature_recipelist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp

import coil.compose.rememberAsyncImagePainter
import com.example.mathongo_assingment.R

import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.ui.theme.boldtitle

@Composable
fun horizontalcard(modifier: Modifier=Modifier,recipe:Recipe,onclick:() -> Unit){
    Card(modifier = modifier.size(width = 250.dp, height = 200.dp).clickable { onclick() }, shape= RoundedCornerShape(15.dp), elevation =CardDefaults.cardElevation(4.dp)) {
       Box( modifier){
            Image( painter = rememberAsyncImagePainter(model = "https://img.spoonacular.com/recipes/${recipe.id}-636x393.${recipe.imageType}") , contentDescription =null, contentScale = ContentScale.Crop, modifier = modifier.fillMaxSize()  )

           Box(
               modifier
                   .fillMaxSize()
                   .background(
                       brush = Brush.verticalGradient(
                           colors = listOf(
                               Color.Transparent,
                               Color.Black.copy(alpha = 0.7f)
                           ),

                           )
                   ))
           Box(
               modifier
                   .fillMaxSize()
                   .padding(13.dp),contentAlignment = Alignment.BottomStart,){
               Column() {
                   Text(text = recipe.title, modifier = modifier.padding(), style = boldtitle, color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis)
                   Text(text =if(recipe.readyInMinutes != null)  stringResource(id = R.string.Ready_in,recipe.readyInMinutes) else "", modifier = modifier.padding(top=5.dp), color = Color.Gray)
               }
           }
       }


    }
}

