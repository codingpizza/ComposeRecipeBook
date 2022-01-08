package com.codingpizza.composerecipebook.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingpizza.composerecipebook.ui.commoncomposables.RecipeScaffold
import com.codingpizza.composerecipebook.ui.theme.md_theme_light_background
import com.codingpizza.composerecipebook.ui.theme.md_theme_light_onPrimary
import com.codingpizza.composerecipebook.ui.theme.md_theme_light_primary
import com.codingpizza.composerecipebook.ui.theme.md_theme_light_secondary

private const val ScreenTitle = "StickyHeader List Composable (Experimental)"

private val randomStrings: List<String> = LoremIpsum().values.first().split(" ")

private val randomStringGrouped: Map<Char, List<String>> =
    randomStrings.groupBy { randomString -> randomString[0] }.toSortedMap()

object StickyHeaderRecipeScreen : Screen {
    override val screenName: String = "StickyHeaderList"
}

@Composable
fun StickyHeaderScreen() {
    RecipeScaffold(screenTitle = ScreenTitle) {
        RecipeListWithHeader(grouped = randomStringGrouped)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeListWithHeader(grouped: Map<Char, List<String>>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        grouped.forEach { (initial, contactsForInitial) ->
            stickyHeader {
                StickyHeader(initial)
            }

            items(contactsForInitial) { ingredient ->
                Text(text = ingredient)
            }
        }
    }
}

@Composable
fun StickyHeader(initial: Char) {
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically ,modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 56.dp)
        .background(MaterialTheme.colors.background)) {
        Text(
            text = initial.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
