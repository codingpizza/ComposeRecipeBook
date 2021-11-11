package com.codingpizza.composerecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingpizza.composerecipebook.ui.screens.*
import com.codingpizza.composerecipebook.ui.theme.ComposeRecipeBookTheme

val recipeList : List<Screen> = listOf(TextFieldRecipeScreen,TextRecipeScreen)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeRecipeBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController, startDestination = CatalogScreen.screenName) {
                        composable(route = CatalogScreen.screenName) {
                            CatalogListScreen(recipeList) {
                                navController.navigate(it.screenName)
                            }
                        }
                        composable(route = TextRecipeScreen.screenName) {
                            TextScreen()
                        }
                        composable(route = TextFieldRecipeScreen.screenName) {
                            TextFieldScreen()
                        }
                    }
                }
            }
        }
    }
}