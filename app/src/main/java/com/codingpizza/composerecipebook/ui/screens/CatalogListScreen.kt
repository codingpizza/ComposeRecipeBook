package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.recipeList
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.theme.ComposeRecipeBookTheme

object CatalogScreen : Screen {
    override val screenName: String = "list"
}

@Composable
fun CatalogListScreen(content: List<Screen>, onItemClicked: (Screen) -> Unit) {
    RecipeScaffold(screenTitle = "Compose Recipe Book") {
        LazyColumn {
            items(content) { recipe ->
                RecipeItemRow(recipe, onItemClicked)
            }
        }
    }
}

@Composable
fun RecipeItemRow(recipe: Screen, onRecipeSelected: (Screen) -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 80.dp)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.clickable { onRecipeSelected(recipe) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = recipe.screenName,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, device = "spec:shape=Normal,width=1080,height=2340,unit=px,dpi=320")
@Composable
fun DefaultPreview() {
    ComposeRecipeBookTheme {
        CatalogListScreen(recipeList) {}
    }
}