package com.explore.bookmyticket.ui.composables

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow

@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit,
) {
    val shouldLoadMore = remember {
        derivedStateOf {

            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?:
            // return false here if loadMore should not be invoked if the list is empty
            return@derivedStateOf false

            lastVisibleItem.index >= layoutInfo.totalItemsCount - 1
        }
    }
    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }.collect {
            // if should load more, then invoke loadMore
            if (shouldLoadMore.value) loadMore()
        }
    }
}