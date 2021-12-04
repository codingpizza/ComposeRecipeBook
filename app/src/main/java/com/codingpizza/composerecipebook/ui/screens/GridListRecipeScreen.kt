package com.codingpizza.composerecipebook.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeSubtitle

private const val ScreenTitle = "Grid List Composable (Experimental)"
private val photoList : List<Int> = (1000..1025).toList()

object GridListRecipeScreen : Screen {
    override val screenName: String = "GridList"
}


@Composable
fun GridListScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        GridList(photoList)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(photos: List<Int>) {
    val imageSize = 128.dp
    RecipeSubtitle(content = "GridList - Dependiendo del tamano de la image la lista incluya espacios en blanco")
    LazyVerticalGrid(
        cells = GridCells.Adaptive(imageSize)
    ) {
        items(photos) { photo ->
            PhotoItem(photo,imageSize)
        }
    }
}

@Composable
fun PhotoItem(photoId: Int, imageSize: Dp) {
    Image(
        painter = rememberImagePainter("https://picsum.photos/id/$photoId/128/128"),
        contentDescription = "Image from url",
        modifier = Modifier.size(imageSize)
    )
}
