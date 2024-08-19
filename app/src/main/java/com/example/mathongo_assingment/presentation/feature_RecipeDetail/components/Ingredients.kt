package com.example.mathongo_assingment.presentation.feature_RecipeDetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.mathongo_assingment.R

@Composable
fun Ingreidemtsdetails(url:String,text:String){
    Column {
        Image(painter = rememberAsyncImagePainter(model =url),contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier
            .size(128.dp)
            .clip(
                CircleShape
            ))
        Text(text = text)

        
    }

}