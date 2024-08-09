package com.example.mathongo_assingment.presentation.feature_RecipeDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mathongo_assingment.R
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.ExpandedToolbar
import com.example.mathongo_assingment.presentation.feature_RecipeDetail.components.collapsedToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  RecipeDetail_Screem() {
    val liststate= rememberLazyListState()
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val isCollapsed: Boolean by remember {
        derivedStateOf {
            scrollBehavior.state.collapsedFraction == 1f
        }
    }
    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                if (isCollapsed) {
                    ExpandedToolbar(scrollBehavior = scrollBehavior)
                } else {
             collapsedToolbar(scrollBehavior = scrollBehavior, iscollapsed = isCollapsed )
                }
            }
        }
    ) {
paddingValues ->  

    }
}

@Preview
@Composable
private fun  RecipeDetilpreview() {
    RecipeDetail_Screem()
}