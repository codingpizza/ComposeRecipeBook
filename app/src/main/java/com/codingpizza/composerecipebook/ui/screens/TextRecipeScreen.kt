package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeSubtitle

object TextRecipeScreen : Screen()

private const val ScreenTitle = "Text Composable"
@Composable
fun TextRecipeScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        RecipeSubtitle(content = "Ejemplo basico de un Text composable")
        TextComposableExample()
        RecipeSubtitle(content = "Text Composable con padding")
        TextPaddingComposableExample()
    }
}

@Composable
fun TextComposableExample(dummyText: String = "Hello world") {
    Text(text = dummyText)
}

@Composable
fun TextPaddingComposableExample(dummyText: String = "Hello world") {
    Text(text = dummyText, modifier=  Modifier.padding(start = 16.dp,end = 16.dp,bottom = 16.dp,top = 16.dp))
}

@Preview
@Composable
fun TextComposableExamplePreview() {
    TextComposableExample()
}

@Preview
@Composable
fun TextRecipeScreenPreview() {
    TextRecipeScreen()
}