package com.codingpizza.composerecipebook.ui.commoncomposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecipeScaffold(screenTitle : String,content: @Composable () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = recipeBookToolbar(title = screenTitle))
    }) {
        Column(modifier = Modifier.fillMaxWidth(),content = { content() })
    }

}