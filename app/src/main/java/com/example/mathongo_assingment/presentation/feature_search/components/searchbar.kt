package com.example.mathongo_assingment.presentation.feature_search.components

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mathongo_assingment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onbackarrowclicked: () -> Unit,
    onclearclicked: () -> Unit,
    modifier: Modifier=Modifier
) {
    TextField(
        modifier=modifier.padding(14.dp),
        value = query,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(15.dp),
        placeholder = { Text(text = stringResource(id = R.string.Placeholder_Search), ) },
        leadingIcon = {
            IconButton(onClick = onbackarrowclicked) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "null")
            }
        },
        trailingIcon = {
            IconButton(onClick =  onclearclicked ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "null")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )


    )
}

@Preview()
@Composable
fun searchbarpreview() {
    SearchBar(query = TextFieldValue(""), onValueChange = {}, onbackarrowclicked = {}, onclearclicked = {})

}