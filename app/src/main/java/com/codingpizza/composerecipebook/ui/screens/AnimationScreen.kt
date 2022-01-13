package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object AnimationScreen : Screen {
    override val screenName: String = "AnimationScreen"
}

private const val ScreenTitle = "Animations"

@Composable
fun AnimationRecipeScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        val items = composableList()
        ComposableExampleLazyColumn(items)
    }
}

@Composable
fun AnimatedTextComposable() {
    var message by remember { mutableStateOf("Hello") }
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(start = 16.dp,top = 8.dp)
            .animateContentSize()
    ) {
        Text(text = message)
    }

    Button(onClick = {
        message = "New message ${getRandomText()}"
    }, modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
        Text(text = "Update animation", color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
fun CrossFadeComposable() {
    var currentPage by remember { mutableStateOf("Add") }
    Crossfade(targetState = currentPage) { screen ->
        when (screen) {
            "Add" -> {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = "Add item",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            "Delete" -> {
                Icon(
                    Icons.Rounded.Delete,
                    contentDescription = "Delete item",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                )
            }
        }
    }
    Button(onClick = {
        currentPage = (if (currentPage == "Add") "Delete" else "Add")
    }, modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
        Text(text = "Update animation", color = MaterialTheme.colors.onPrimary)
    }
}

fun getRandomText(): String = LoremIpsum().values.first().split(" ").shuffled().firstOrNull() ?: ""

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Animated Content size", composable = { AnimatedTextComposable() }),
    ComposableExample(title = "Crossfade Animation", composable = { CrossFadeComposable() }),
)
