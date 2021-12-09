package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import kotlinx.coroutines.launch


private const val ScreenTitle = "Reacting to Scroll Position Screen"
private val randomStrings: List<String> = LoremIpsum().values.first().split(" ")

object ReactingScrollPositionScreen : Screen {
    override val screenName: String = "reactingScrollPosition"
}


@Composable
fun ReactingScrollPositionRecipeScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        Box {

            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            val isListScrolled by remember {
                derivedStateOf {
                    listState.firstVisibleItemIndex > 0
                }
            }

            val listModifier = if (isListScrolled) {
                Modifier.fillMaxWidth().fillMaxHeight()
            } else {
                Modifier.fillMaxWidth().fillMaxHeight().padding(top = 32.dp)
            }

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                modifier = listModifier
            ) {
                items(randomStrings) { myRandomString -> Text(text = myRandomString) }
            }

            if (isListScrolled) {
                Button(modifier = Modifier
                    .align(Alignment.BottomCenter), onClick = {
                    coroutineScope.launch {
                        // Animate scroll to the first item
                        listState.animateScrollToItem(index = 0)
                    }
                }) {
                    Text("Ir al inicio")
                }
            } else {
                Text(
                    text = "Has scroll para ver mas",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

        }
    }
}