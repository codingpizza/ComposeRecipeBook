package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.codingpizza.composerecipebook.R
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

private const val ScreenTitle = "Images Composable"

object ImageRecipeScreen : Screen {
    override val screenName: String = "Images"
}

@Composable
fun ImageRecipeScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        ComposableExampleLazyColumn(items = composableList())
    }
}

private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Imagen con drawable", composable = { ImageWithDrawable() }),
    ComposableExample(title = "Icon de Material Icon", composable = { IconFromMaterial() }),
    ComposableExample(title = "Imagen en local", composable = { ImageFromLocal() }),
    ComposableExample(title = "Imagen circular", composable = { CircularImage() }),
    ComposableExample(title = "Imagen desde url usando Coil", composable = { ImageFromUrl() }),
    ComposableExample(title = "Imagen desde url usando Coil con transformaciones", composable = { ImageFromUrlCircleCrop() }),
)

/***
 * Requires Coil library https://coil-kt.github.io/coil/compose/
 */
@Composable
fun ImageFromUrlCircleCrop() {
    Column(modifier= Modifier.fillMaxWidth()) {
        Image(
            painter = rememberImagePainter("https://picsum.photos/id/1025/200/300",
                builder =  {
                    transformations(CircleCropTransformation())
                }),
            contentDescription = "Image from url",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(240.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "Tomada de Lorem Picsum utilizando la libreria Coil",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

/***
 * Requires Coil library https://coil-kt.github.io/coil/compose/
 */
@Composable
fun ImageFromUrl() {
    Column(modifier= Modifier.fillMaxWidth()) {
        Image(
            painter = rememberImagePainter("https://picsum.photos/id/1025/200/300"),
            contentDescription = "Image from url",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(240.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "Tomada de Lorem Picsum utilizando la libreria Coil",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun CircularImage() {
    Column(modifier= Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile picture",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(240.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "Tomada de developer.android.com",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun ImageFromLocal() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.recipe),
            contentDescription = "Recipe picture",
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Text(
            "Photo by Mariana Medvedeva on Unsplash",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ImageWithDrawable() {
    Icon(
        painter = painterResource(id = R.drawable.ic_baseline_adb_24),
        contentDescription = null,
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun IconFromMaterial() {
    Icon(
        Icons.Rounded.Lock,
        contentDescription = "Lock",
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
    )
}
