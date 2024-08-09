package com.example.mathongo_assingment.presentation.feature_RecipeDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.ui.theme.boldtitle

@Composable
fun basicdetails(modifier:Modifier){
Row(modifier = modifier,Arrangement.SpaceBetween) {
    Card(modifier.padding(4.dp), shape = RoundedCornerShape(15.dp), ) {
       Text(text = stringResource(id = R.string.Details_ReadyIn), textAlign = TextAlign.Center)
        Text(text = "25 min", style = boldtitle,textAlign = TextAlign.Center,color=MaterialTheme.colorScheme.primary)
    }
    Card(modifier.padding(4.dp), shape = RoundedCornerShape(15.dp), ) {
        Text(text = stringResource(id = R.string.Details_Servings),textAlign = TextAlign.Center)
        Text(text = "6", style = boldtitle,textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.primary)
    }
    Card(modifier.padding(4.dp), shape = RoundedCornerShape(15.dp), ) {
        Text(text = stringResource(id = R.string.Details_Price),textAlign = TextAlign.Center)
        Text(text = "156", style = boldtitle,textAlign = TextAlign.Center,color=MaterialTheme.colorScheme.primary)
    }
}
}