package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeSubtitle

private const val ScreenTitle = "Lists Composable"
private val recipeList: List<String> = listOf("Risotto", "Pizza", "Focaccia")
private val ingredientList: List<String> = listOf(
    "Tomate",
    "Harina",
    "Aceite de oliva",
    "Oregano",
    "Queso",
    "Berenjena"
)

object ListRecipeScreen : Screen {
    override val screenName: String = "List"
}

@Composable
fun ListScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        Column {
            RecipeSubtitle(content = "Lista simple con pocos elementos")
            recipeList.forEach { message ->
                RecipeRow(message)
            }
            RecipeSubtitle(content = "Lista simple con muchos elementos (Recomendada cuando hay muchos elementos)")
            MyLazyColumn()
        }
    }
}

/***
 * Content Padding es opcional.
 * https://developer.android.com/jetpack/compose/lists#content-padding
 * Vertical Arrangement es opcional. Usalo para posicionar los elementos de una lista de distintas formas
 * https://developer.android.com/jetpack/compose/lists#content-spacing
 */
@Composable
fun MyLazyColumn() {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp) ,verticalArrangement = Arrangement.SpaceEvenly , content = {
        items(items = ingredientList) { ingredient: String ->
            IngredientRow(ingredient)
        }
    })
}

@Composable
fun RecipeRow(recipe: String) {
    Text(text = "Recipe: $recipe", modifier = Modifier
        .fillMaxWidth())
}

@Composable
fun IngredientRow(ingredient: String) {
    Text(text = "Ingredient: $ingredient", modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth())
}

