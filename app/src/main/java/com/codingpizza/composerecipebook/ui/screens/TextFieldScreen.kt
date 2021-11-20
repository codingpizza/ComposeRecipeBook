package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExample
import com.codingpizza.composerecipebook.ui.commoncomposables.ComposableExampleLazyColumn
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold


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
        val items = composableList()
        ComposableExampleLazyColumn(items)
    }
}

@Composable
private fun composableList(): List<ComposableExample> = listOf(
    ComposableExample(title = "Textfield", composable = { TextFieldWithState() }),
    ComposableExample(title = "Outlined TextField", composable = { OutlinedTextFieldExample() }),
    ComposableExample(
        title = "Outlined Textfield con Icon",
        composable = { OutlinedTextFieldIconExample() }),
    ComposableExample(
        title = "Outlined Textfield con icono al inicio (Trailing Icon)",
        composable = { OutlinedTextFieldTrailingIconExample() }),
    ComposableExample(
        title = "Outlined Textfield con animación de contraseña",
        composable = { OutlinedTextFieldPasswordExample() }),
)

@Composable
fun OutlinedTextFieldExample() {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        singleLine = true
    )
}

@Composable
fun OutlinedTextFieldIconExample() {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        singleLine = true,
        leadingIcon = {
            Icon(Icons.Rounded.Face, contentDescription = "Name")
        }
    )
}

@Composable
fun OutlinedTextFieldTrailingIconExample() {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        singleLine = true,
        trailingIcon = {
            Icon(Icons.Rounded.Email, contentDescription = "Email")
        }
    )
}

@Composable
fun OutlinedTextFieldPasswordExample() {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Contraseña") },
        singleLine = true,
        trailingIcon = { Icon(Icons.Rounded.Lock, contentDescription = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
    )
}


@Composable
fun TextFieldWithState() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        singleLine = true
    )
}

@Preview
@Composable
fun TextFieldScreenPreview() {
    TextFieldScreen()
}


