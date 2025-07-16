package com.example.mathongo_assingment.presentation.feature_RecipeDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.ui.theme.boldtitle

@Composable
fun Basicdetails(modifier: Modifier, readyin: String, servings: String, price: String) {
    Row(modifier = modifier.fillMaxWidth().padding(5.dp), Arrangement.SpaceBetween) {
        OutlinedCard(
            modifier
                .padding(start = 10.dp)
                .widthIn(min = 100.dp, max = 100.dp),
            colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = stringResource(id = R.string.Details_ReadyIn),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = readyin,
                    style = boldtitle,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        OutlinedCard(
            modifier
                .padding(start=10.dp)
                .widthIn(min = 100.dp, max = 100.dp),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = stringResource(id = R.string.Details_Servings),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = servings,
                    style = boldtitle,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }
        OutlinedCard(
            modifier
                .padding(start =10.dp)
                .widthIn(min = 100.dp, max = 150.dp),
            shape = RoundedCornerShape(15.dp),
        ) {
            Column(
                modifier.width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier.padding( start = 5.dp, top = 10.dp, bottom = 10.dp, end = 5.dp),
                    text = stringResource(id = R.string.Details_Price),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = modifier.padding( top = 10.dp, bottom = 10.dp),
                    text = price,
                    style = boldtitle,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
    }
}