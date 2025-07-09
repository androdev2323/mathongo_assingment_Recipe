package com.example.mathongo_assingment.presentation.feature_search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SectionalHeader(
    text: String,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onClick: () -> Unit,
    buttonTitle:String,
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(isExpanded) }
    Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            IconButton(onClick = {
                if (!expanded) {
                    onToggle()
                }
                expanded = !expanded
            }
            ) {
                if (expanded) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Collapse",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Collapse",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
     AnimatedVisibility(expanded) {
         Column {
             content()
             Spacer(modifier = Modifier.height(5.dp))
             ActionButton(Title = buttonTitle) {
                 expanded = !expanded
                 onClick()
             }

         }
     }
    }


}

@Composable
fun ActionButton(
    Title: String,
    onClicked: () -> Unit
) {
    Button(onClick = { onClicked() },
        colors = ButtonDefaults.buttonColors()
            .copy(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(text = Title)
    }
}