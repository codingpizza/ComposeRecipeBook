package com.codingpizza.composerecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.theme.ComposeRecipeBookTheme

private val recipeList = listOf("Text")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecipeBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatalogListScreen(recipeList)
                }
            }
        }
    }
}

@Composable
fun CatalogListScreen(content: List<String>) {
    LazyColumn {
        items(content) { recipe ->
            RecipeItemRow(recipe)
        }
    }
}

@Composable
fun RecipeItemRow(recipe: String, onRecipeSelected: (String) -> Unit = {}) {
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
                text = recipe,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview(device = "spec:shape=Normal,width=1080,height=2340,unit=px,dpi=320")
@Composable
fun RecipeItemRowPreview() {
    val recipe = "Pizza con piña"
    RecipeItemRow(recipe = recipe)
}

@Preview(showBackground = true, device = "spec:shape=Normal,width=1080,height=2340,unit=px,dpi=320")
@Composable
fun DefaultPreview() {
    ComposeRecipeBookTheme {
        CatalogListScreen(recipeList)
    }
}