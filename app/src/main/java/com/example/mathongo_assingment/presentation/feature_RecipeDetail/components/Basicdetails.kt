package com.example.mathongo_assingment.presentation.feature_RecipeDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.ui.theme.boldtitle

@Composable
fun Basicdetails(modifier:Modifier,readyin:String,servings:String,price:String){
Row(modifier = modifier.fillMaxWidth(),Arrangement.SpaceBetween) {
    OutlinedCard(modifier.padding(15.dp).widthIn(min = 100.dp), shape = RoundedCornerShape(15.dp), ) {
       Text(modifier = modifier.padding(10.dp), text = stringResource(id = R.string.Details_ReadyIn), textAlign = TextAlign.Center)
        Text(modifier = modifier.padding( 10.dp),textAlign = TextAlign.Center,text = readyin,style = boldtitle,color=MaterialTheme.colorScheme.primary)
    }
    OutlinedCard(modifier.padding(15.dp).widthIn(min=100.dp), shape = RoundedCornerShape(15.dp), ) {
        Text(modifier = modifier.padding(10.dp),text = stringResource(id = R.string.Details_Servings),textAlign = TextAlign.Center)
        Text(modifier = modifier.padding(10.dp),text = servings, style = boldtitle,textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.primary)
    }
    OutlinedCard(modifier.padding(15.dp).widthIn(100.dp), shape = RoundedCornerShape(15.dp), ) {
        Text(modifier = modifier.padding(10.dp),text = stringResource(id = R.string.Details_Price),textAlign = TextAlign.Center)
        Text(modifier = modifier.padding(10.dp),text = price, style = boldtitle,textAlign = TextAlign.Center,color=MaterialTheme.colorScheme.primary)
    }
}
}