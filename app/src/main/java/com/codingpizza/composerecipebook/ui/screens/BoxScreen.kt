package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object BoxScreen : Screen {
    override val screenName: String = "Box"
}

@Composable
fun BoxRecipeScreen() {
    RecipeScaffold(screenTitle = "Box") {
        ComposableExampleLazyColumn(items = composableList())
    }
}

@Composable
private fun MyBoxComposable() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier= Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter("https://picsum.photos/id/1025/200/300"),
                contentDescription = "Image from url",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .size(240.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Row(modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .align(Alignment.BottomEnd)) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Share",
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star",
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
private fun MyBoxComposableWithThreeComposables() {
    Box(modifier = Modifier
        .background(Color.Gray)
        .fillMaxSize()
        .height(200.dp)) {
        RedBox(modifier = Modifier.align(Alignment.TopCenter))
        BlueBox(modifier = Modifier.align(Alignment.TopStart))
        GreenBox(modifier = Modifier.align(Alignment.TopEnd))
    }
}

@Composable
private fun GreenBox(modifier: Modifier) {
    Box(modifier = modifier
        .background(Color.Green)
        .size(60.dp)) {

    }
}

@Composable
private fun BlueBox(modifier: Modifier) {
    Box(modifier = modifier
        .background(Color.Blue)
        .size(60.dp)) {

    }
}

@Composable
private fun RedBox(modifier: Modifier) {
    Box(modifier = modifier
        .background(Color.Red)
        .size(60.dp)) {

    }
}

@Composable
private fun BoxWithConstraintsExample() {
    BoxWithConstraints {
        if (maxWidth < 400.dp) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = rememberImagePainter("https://picsum.photos/id/1025/200/300"),
                    contentDescription = "Image from url",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(240.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text("This is a caption")
            }
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = rememberImagePainter("https://picsum.photos/id/1025/200/300"),
                    contentDescription = "Image from url",
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .size(240.dp)
                )
                Text("This is a caption")
            }
        }
    }
}

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Box",composable = { MyBoxComposable() } ),
    ComposableExample(title = "Ejemplo de Box",composable = { MyBoxComposableWithThreeComposables() } ),
    ComposableExample("Box with Constraints", composable = { BoxWithConstraintsExample() })
)