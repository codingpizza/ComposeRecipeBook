package com.codingpizza.composerecipebook.ui.commoncomposables

import androidx.compose.runtime.Composable

data class ComposableExample(val title: String, val composable: @Composable () -> Unit)