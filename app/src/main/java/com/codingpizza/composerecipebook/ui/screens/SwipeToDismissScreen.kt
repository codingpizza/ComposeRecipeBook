package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import kotlin.math.roundToInt

object SwipeToDismissScreen : Screen {
    override val screenName: String = "Swipe To Dismiss"
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDismissRecipeScreen() {
    RecipeScaffold(screenTitle = ("Swipe to Dismiss")) {
        val squareSize = 80.dp
        val swipeableState = rememberSwipeableState(0)
        val sizePx = with(LocalDensity.current) { squareSize.toPx() }
        val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    orientation = Orientation.Horizontal,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    )
                .background(Color.LightGray)
        ) {
            Box(
                Modifier
                    .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                    .size(squareSize)
                    .background(Color.DarkGray)
            )
        }
    }
}
