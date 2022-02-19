package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.R
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold

object TappingScreen : Screen {
    override val screenName: String = "Tap gestures"
}

@Composable
fun TapingRecipeScreen() {
    RecipeScaffold(screenTitle = "Tapping and Pressing") {
        Text("Haz click en la imagen para ver cambios")
        val myTextState = remember { mutableStateOf("No se ha hecho ninguna acción")  }
        Text(myTextState.value)
        Image(
            painter = painterResource(id = R.drawable.recipe),
            contentDescription = "Recipe picture",
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = { myTextState.value = "Android OnPress" },
                        onDoubleTap = { myTextState.value = "Android DoubleTap" },
                        onLongPress = { myTextState.value = "Android OnLongPress" },
                        onTap = { myTextState.value = "Android Tap" }
                    )
                }
        )
    }
}