package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.material.*
import androidx.compose.material.SnackbarResult.ActionPerformed
import androidx.compose.material.SnackbarResult.Dismissed
import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


object SnackbarScreen : Screen {
    override val screenName: String = "Snackbar"
}

@Composable
fun SnackbarRecipeScreen() {
    val scaffoldState = rememberScaffoldState()
    val composableScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        val showText = remember { mutableStateOf(false) }
        ShowSnackbarButton(composableScope, scaffoldState, showText)
        if (showText.value) {
            Text("Información cargada correctamente")
        }
    }
}

@Composable
private fun ShowSnackbarButton(
    composableScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    showText: MutableState<Boolean>
) {
    Button(onClick = {
        composableScope.launch {
            showSnackbar(scaffoldState, showText)
        }
    }) {
        Text("Try me")
    }
}


private suspend fun showSnackbar(
    scaffoldState: ScaffoldState,
    showText: MutableState<Boolean>
) {
    val result: SnackbarResult =
        scaffoldState.snackbarHostState.showSnackbar("Hello world!", "retry")
    when (result) {
        Dismissed -> showText.value = false
        ActionPerformed -> showText.value = true
    }
}