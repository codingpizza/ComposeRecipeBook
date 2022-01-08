package com.codingpizza.composerecipebook.ui.commoncomposables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun recipeBookToolbar(title: String): @Composable () -> Unit = { ToolbarTitle(title) }

@Composable
fun ToolbarTitle(title: String) {
    Text(text = title, fontSize = 16.sp)
}