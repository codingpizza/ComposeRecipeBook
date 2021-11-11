package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object TextRecipeScreen : Screen()

@Composable
fun TextRecipeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { ToolbarTitle() })
    }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Title(content = "Ejemplo basico de un Text composable")
            TextComposableExample()
            Title(content = "Text Composable con padding")
            TextPaddingComposableExample()
        }
    }
}

@Composable
fun Title(content: String) {
    Text(
        text = content,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ToolbarTitle() {
    Text(text = "Text Composable", fontSize = 24.sp)
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