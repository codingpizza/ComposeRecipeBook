package com.codingpizza.composerecipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingpizza.composerecipebook.ui.screens.*
import com.codingpizza.composerecipebook.ui.theme.ComposeRecipeBookTheme

val recipeList: List<Screen> = listOf(
    TextFieldRecipeScreen,
    TextRecipeScreen,
    ImageRecipeScreen,
    ListRecipeScreen,
    StickyHeaderRecipeScreen,
    GridListRecipeScreen,
    ReactingScrollPositionScreen,
    AnimationScreen,
    ColumnScreen,
    RowScreen,
    BoxScreen,
    SnackbarScreen,
    DialogScreen,
    TappingScreen,
    DraggingScreen,
    SwipeToDismissScreen,
    MultiTouchScreen
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeRecipeBookTheme {
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
                        composable(route = ImageRecipeScreen.screenName) {
                            ImageRecipeScreen()
                        }
                        composable(route = ListRecipeScreen.screenName) {
                            ListScreen()
                        }
                        composable(route = StickyHeaderRecipeScreen.screenName) {
                            StickyHeaderScreen()
                        }
                        composable(route = GridListRecipeScreen.screenName) {
                            GridListScreen()
                        }
                        composable(route = ReactingScrollPositionScreen.screenName) {
                            ReactingScrollPositionRecipeScreen()
                        }
                        composable(route = AnimationScreen.screenName) {
                            AnimationRecipeScreen()
                        }
                        composable(route = ColumnScreen.screenName) {
                            ColumnRecipeScreen()
                        }
                        composable(route = RowScreen.screenName) {
                            RowRecipeScreen()
                        }
                        composable(route = BoxScreen.screenName) {
                            BoxRecipeScreen()
                        }
                        composable(route = SnackbarScreen.screenName) {
                            SnackbarRecipeScreen()
                        }
                        composable(route = DialogScreen.screenName) {
                            DialogRecipeScreen()
                        }
                        composable(route = TappingScreen.screenName) {
                            TapingRecipeScreen()
                        }
                        composable(route = DraggingScreen.screenName) {
                            DraggingScreen()
                        }
                        composable(route = SwipeToDismissScreen.screenName) {
                            SwipeToDismissRecipeScreen()
                        }
                        composable(route = MultiTouchScreen.screenName) {
                            MultiTouchRecipeScreen()
                        }
                    }
                }
            }
        }
    }

}