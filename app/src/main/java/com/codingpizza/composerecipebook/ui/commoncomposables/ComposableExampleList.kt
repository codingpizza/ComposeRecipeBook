package com.codingpizza.composerecipebook.ui.commoncomposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun ComposableExampleLazyColumn(items: List<ComposableExample>) {
    LazyColumn {
        items(items) { composableExample ->
            ComposableExampleRow(
                title = composableExample.title,
                content = composableExample.composable
            )
        }
    }
}


@Composable
fun ComposableExampleRow(title: String, content: @Composable () -> Unit) {
    Column {
        RecipeSubtitle(title)
        content()
    }
}