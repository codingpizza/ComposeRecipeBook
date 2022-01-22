package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
    var message by remember { mutableStateOf("Hola") }
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(start = 16.dp, top = 8.dp)
            .animateContentSize()
    ) {
        Text(text = message)
    }

    Button(onClick = {
        message = "Nuevo mensaje ${getRandomText()}"
    }, modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
        Text(text = "Actualizar animacion", color = MaterialTheme.colors.onPrimary)
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
        Text(text = "Actualizar animacion", color = MaterialTheme.colors.onPrimary)
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityComposable() {
    var editable by remember { mutableStateOf(true) }
    AnimatedVisibility(visible = editable) {
        Column {
            Text(text = "Esto es un texto muy largo")

            Button(onClick = {
                editable = !editable
            }, modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
                Text(text = "Cerrar notificacion", color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentComposable() {
    Column {
        var count by remember { mutableStateOf(0) }

        Row {
            Text(text = "Contador", modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            AnimatedContent(targetState = count) { targetCount ->
                Text(text = "$targetCount")
            }
        }

        Button(onClick = { count++ }, modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
            Text("Sumar")
        }
    }
}

fun getRandomText(): String = LoremIpsum().values.first().split(" ").shuffled().firstOrNull() ?: ""

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Animated Content size", composable = { AnimatedTextComposable() }),
    ComposableExample(title = "Crossfade Animation", composable = { CrossFadeComposable() }),
    ComposableExample(title = "Animated Visibility - Experimental", composable = { AnimatedVisibilityComposable() }),
    ComposableExample(title = "Animated Content - Experimental", composable = { AnimatedContentComposable() }),
)
