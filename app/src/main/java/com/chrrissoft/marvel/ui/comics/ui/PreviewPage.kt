package com.chrrissoft.marvel.ui.comics.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.chrrissoft.marvel.ui.comics.ComicsPreview
import com.chrrissoft.marvel.ui.comics.ComicsScreenState.PreviewResState
import com.chrrissoft.marvel.ui.comics.ComicsScreenState.PreviewResState.*

@Composable
internal fun ComicsPreviewPage(
    list: List<ComicsPreview>,
    previewResState: PreviewResState,
    onLoadMore: () -> Unit,
) {

    val scroll: LazyListState = rememberLazyListState()

    val loadMore = remember() {
        derivedStateOf { (scroll.firstVisibleItemIndex) > (list.size - 10) }
    }

    if (loadMore.value) onLoadMore()

    LazyColumn(
        state = scroll
    ) {
        itemsIndexed(list) { _, e ->
            ComicsPreviewUi(e)
        }

        when (previewResState) {
            LOADING -> {
                item { Text(text = "LOADING", color = Color.Red, fontSize = 20.sp) }
            }
            ERROR -> {
                item { Text(text = "ERROR", color = Color.Red, fontSize = 20.sp) }
            }
            SUCCESS -> {
                item { Text(text = "SUCCESS", color = Color.Red, fontSize = 20.sp) }
            }
        }
    }
}

