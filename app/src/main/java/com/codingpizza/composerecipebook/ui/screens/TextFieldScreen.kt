package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeSubtitle

/***
 *  Documentation:
 *  https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TextField(kotlin.String,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Boolean,kotlin.Boolean,androidx.compose.ui.text.TextStyle,kotlin.Function0,kotlin.Function0,kotlin.Function0,kotlin.Function0,kotlin.Boolean,androidx.compose.ui.text.input.VisualTransformation,androidx.compose.foundation.text.KeyboardOptions,androidx.compose.foundation.text.KeyboardActions,kotlin.Boolean,kotlin.Int,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.ui.graphics.Shape,androidx.compose.material.TextFieldColors)
 */

private const val ScreenTitle = "TextField Composable"

object TextFieldRecipeScreen : Screen {
    override val screenName: String = "TextField"

}

@Composable
fun TextFieldScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        RecipeSubtitle("Textfield con state")
        TextFieldWithState()
    }
}

@Composable
fun TextFieldWithState() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        singleLine = true
    )
}

@Preview
@Composable
fun TextFieldScreenPreview() {
    TextFieldScreen()
}


