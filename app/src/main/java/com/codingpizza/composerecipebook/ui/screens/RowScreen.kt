package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object RowScreen : Screen {
    override val screenName: String = "Row"
}

@Composable
fun RowRecipeScreen() {
    RecipeScaffold(screenTitle = "Column Screen") {
        ComposableExampleLazyColumn(items = composableList())
    }
}

@Composable
fun SimpleRow() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp)) {
        Text("Primer Texto")
        Text("Segundo Texto")
    }
}


@Composable
fun SimpleRowEnd() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp), horizontalArrangement = Arrangement.End) {
        Text("Primer Texto")
        Text("Segundo Texto")
    }
}

@Composable
fun SimpleRowSpaceEvenly() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        Text("Primer Texto")
        Text("Segundo Texto")
        Text("Tercero Texto")
    }
}


@Composable
fun SimpleRowSpaceAround() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Text("Primer Texto")
        Text("Segundo Texto")
        Text("Tercero Texto")
    }
}

@Composable
fun SimpleRowAlignment() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp), verticalAlignment = Alignment.CenterVertically) {
        Text("Primer Texto")
        Text("Segundo Texto")
    }
}

@Composable
fun SimpleRowBottomAlignment() {
    Row(modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().height(200.dp), verticalAlignment = Alignment.Bottom) {
        Text("Primer Texto")
        Text("Segundo Texto")
    }
}


@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Fila con dos elementos", composable = { SimpleRow() }),
    ComposableExample(title = "Fila con dos elementos al final", composable = { SimpleRowEnd() }),
    ComposableExample(title = "Fila con dos elementos distribuidos equitativamente", composable = { SimpleRowSpaceEvenly() }),
    ComposableExample(title = "Fila con dos elementos distribuidos con espacio alrededor", composable = { SimpleRowSpaceAround() }),
    ComposableExample(title = "Fila con dos elementos distribuidos y alineación vertical centrada", composable = { SimpleRowAlignment() }),
    ComposableExample(title = "Fila con dos elementos distribuidos y alineación vertical al fondo", composable = { SimpleRowBottomAlignment() }),
)