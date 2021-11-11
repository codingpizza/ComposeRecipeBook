package com.codingpizza.composerecipebook.ui.commoncomposables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecipeSubtitle(content: String) {
    Text(
        text = content,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}