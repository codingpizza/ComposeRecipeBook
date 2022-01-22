package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object ColumnScreen : Screen{
    override val screenName: String = "Column"
}

@Composable
fun ColumnRecipeScreen() {
    RecipeScaffold(screenTitle = "Column Screen") {
        ComposableExampleLazyColumn(items = composableList())
    }
}

@Composable
fun SimpleColumn() {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary).height(250.dp)) {
        Text("Mi nombre es: John", modifier = Modifier.fillMaxWidth())
        Text("Mi apellido es: Smith")
    }
}

@Composable
fun SimpleColumnBottom() {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary).height(250.dp), verticalArrangement = Arrangement.Bottom) {
        Text("Mi nombre es: John", modifier = Modifier.fillMaxWidth())
        Text("Mi apellido es: Smith")
    }
}

@Composable
fun SimpleColumnSpaceEvenly() {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary).height(250.dp), verticalArrangement = Arrangement.SpaceEvenly) {
        Text("Editar Perfil", modifier = Modifier.fillMaxWidth())
        Text("Preguntas Frecuentes")
        Text("Terminos y condiciones", modifier = Modifier.fillMaxWidth())
        Text("Sobre nosotros")
    }
}

@Composable
fun SimpleColumnSpaceBetween() {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary).height(250.dp), verticalArrangement = Arrangement.SpaceEvenly) {
        Text("Tu información", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold)
        Text("Tenemos todos tus datos para venderlos para venderlos a terceros")
        Button(onClick = {}) {
            Text("Aceptar")
        }
    }
}

@Composable
fun SimpleColumnHorizontal() {
    Column(modifier = Modifier.background(MaterialTheme.colors.primary).height(250.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Alinear items por inicio, final o centrado horizontalmente", fontWeight = FontWeight.Bold)
        Text("El alignment")
        Text("Center Horizontal")
    }
}

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Columna con dos elementos arriba", composable = { SimpleColumn() }),
    ComposableExample(title = "Columna con dos elementos abajo", composable = { SimpleColumnBottom() }),
    ComposableExample(title = "Columna con dos elementos distribuidos equitativamente", composable = { SimpleColumnSpaceEvenly() }),
    ComposableExample(title = "Columna con dos elementos distribuidos", composable = { SimpleColumnSpaceBetween() }),
    ComposableExample(title = "Columna Horizontal con dos elementos distribuidos", composable = { SimpleColumnHorizontal() }),
)