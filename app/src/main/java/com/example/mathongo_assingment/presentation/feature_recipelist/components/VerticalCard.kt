package com.example.mathongo_assingment.presentation.feature_recipelist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.domain.model.Recipe
import com.example.mathongo_assingment.ui.theme.boldtitle


@Composable
fun VerticalCard(modifier: Modifier = Modifier, recipe: Recipe) {
    Card(shape = RoundedCornerShape(15.dp), elevation = CardDefaults.cardElevation(5.dp), border = CardDefaults.outlinedCardBorder(), colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.background)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(color = MaterialTheme.colorScheme.background
                )
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://img.spoonacular.com/recipes/${recipe.id}-312x231.${recipe.imageType}"),
                contentDescription = "",
                modifier
                    .fillMaxHeight()
                    .width(150.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)) {
                Text(
                    text = recipe.title,
                    style = boldtitle.copy(fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground),
                    maxLines = 1,
                    textAlign=TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = stringResource(id = R.string.Ready_in,recipe.readyInMinutes),
                    textAlign=TextAlign.Center,
                    color = Color.Gray)

            }

        }
    }
}