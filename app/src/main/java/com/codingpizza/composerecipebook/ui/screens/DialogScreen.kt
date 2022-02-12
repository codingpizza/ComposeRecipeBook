package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object DialogScreen : Screen {
    override val screenName: String = "Dialogs"
}

@Composable
fun DialogRecipeScreen() {
    RecipeScaffold(screenTitle = "Dialog Screen") {
        ComposableExampleLazyColumn(composableList())
    }
}

@Composable
private fun AlertDialogWithCustomButtons() {
    val openDialog = remember { mutableStateOf(false) }

    Button(onClick =  {
        openDialog.value = true
    }) {
        Text("Mostrar Dialogo")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Deseas continuar con los ejemplos?")
            },
            text = {
                Text("Quieres continuar viendo como hacer maravillas con compose")
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
            buttons = {
                Row(modifier = Modifier.clickable { openDialog.value = false }) {
                    Icon(
                        Icons.Rounded.CheckCircle,
                        contentDescription = "Check",
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                    )
                    Text("Si, por favor no seas pesado. Cierra esto.")
                }
            }
        )
    }
}

@Composable
private fun AlertDialogNonDismissibleExample() {
    val openDialog = remember { mutableStateOf(false) }

    Button(onClick =  {
        openDialog.value = true
    }) {
        Text("Mostrar Dialogo")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Deseas continuar con los ejemplos?")
            },
            text = {
                Text("Quieres continuar viendo como hacer maravillas con compose")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Descartar")
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}

@Composable
private fun AlertDialogExample() {
    val openDialog = remember { mutableStateOf(false) }
    Button(onClick =  {
        openDialog.value = true
    }) {
        Text("Mostrar Dialogo")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Deseas continuar con los ejemplos?")
            },
            text = {
                Text("Quieres continuar viendo como hacer maravillas con compose")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Descartar")
                }
            }
        )
    }
}

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Ejemplo de Alert Dialog", composable = { AlertDialogExample() }),
    ComposableExample(title = "Ejemplo de Alert Dialog obligatorio", composable = { AlertDialogNonDismissibleExample() }),
    ComposableExample(title = "Ejemplo de Alert Dialog con botones custom", composable = { AlertDialogWithCustomButtons() }),
)