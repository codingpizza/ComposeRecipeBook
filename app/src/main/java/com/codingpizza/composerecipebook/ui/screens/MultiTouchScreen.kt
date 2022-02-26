package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import coil.compose.rememberImagePainter
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object MultiTouchScreen : Screen {
    override val screenName: String = "MultiTouch"
}

@Composable
fun MultiTouchRecipeScreen() {
    RecipeScaffold(screenTitle = "MultiTouch") {
        ZoomWithAutomaticallyReset()
    }
}

/***
 * Esto un composable que utiliza MultiTouch para poder hacer zoom cuando se expande y dejar de hacerlo cuando se suelta la imagen
 */
@Composable
private fun ZoomWithAutomaticallyReset() {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var transformProgress by remember { mutableStateOf(false) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        offset += offsetChange
    }
    transformProgress = state.isTransformInProgress
    if (!transformProgress) {
        scale = 1f
        offset = Offset.Zero
    }
    Image(
        painter = rememberImagePainter("https://picsum.photos/id/1025/200/300"),
        contentDescription = "Image from url",
        modifier = Modifier
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offset.x,
                translationY = offset.y
            )
            .transformable(state = state)
            .fillMaxSize()
    )
}