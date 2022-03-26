package com.codingpizza.composerecipebook.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import kotlin.math.roundToInt

object DraggingScreen : Screen {
    override val screenName: String = "Drag Gestures"
}

@Composable
fun DraggingScreen() {
    RecipeScaffold(screenTitle = "Dragging") {
        Box(modifier = Modifier.fillMaxSize()) {
            BoxWithOnLongPressed(modifier = Modifier.align(Alignment.TopStart))
            BoxWithDragGesture(modifier = Modifier.align(Alignment.TopEnd))
        }
    }
}

@Composable
private fun BoxWithDragGesture(modifier: Modifier) {
    Box(modifier = modifier.size(160.dp)) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var colorState by remember { mutableStateOf(Color.Blue) }
        Log.d("Offset", "Offset X = $offsetX")
        Log.d("Offset", "Offset X = $offsetY")
        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(colorState)
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(onDragStart = {
                        Log.d("DragGestures", "OnDragStart")
                        colorState = Color.Yellow
                    }, onDragEnd = {
                        Log.d("DragGestures", "OnDragEnd")
                        colorState = Color.Blue
                    }, onDragCancel = {
                        Log.d("DragGestures", "OnDragCancel")
                    }, onDrag = { change, dragAmount ->
                        Log.d("Lambda", "Change value $change DragAmount $dragAmount")
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    })
                }
        ) {
            Text(text = "No hace falta mantener presionado para mover")
        }
    }
}

@Composable
private fun BoxWithOnLongPressed(modifier: Modifier) {
    Box(modifier = modifier.size(160.dp)) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var colorState by remember { mutableStateOf(Color.Red) }
        Log.d("Offset", "Offset X = $offsetX")
        Log.d("Offset", "Offset X = $offsetY")
        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(colorState)
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGesturesAfterLongPress(onDragStart = {
                        Log.d("DragGestures", "OnDragStart")
                        colorState = Color.Green
                    }, onDragEnd = {
                        Log.d("DragGestures", "OnDragEnd")
                        colorState = Color.Red
                    }, onDragCancel = {
                        Log.d("DragGestures", "OnDragCancel")
                    }, onDrag = { change, dragAmount ->
                        Log.d("Lambda", "Change value $change DragAmount $dragAmount")
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    })
                }
        ) {
            Text(text = "Manten presionado para mover")
        }
    }
}
