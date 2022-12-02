package com.chrrissoft.marvel.ui.common.info.preview

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.ui.stories.StoryPreview
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.ui.common.info.PrevListTitle
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoError
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoLoading
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoSuccess
import com.chrrissoft.marvel.R.string.route_name__stories
import com.chrrissoft.marvel.ui.INFO_STATE
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.*

@Composable
fun StoriesPreviewsInInfo(
    res: StoriesPrevRes,
    modifier: Modifier = Modifier,
    onLoadMore: () -> Unit,
) {
    Log.d(INFO_STATE, "Stories on Info   ->   ${res.state}")
    Column(modifier) {
        PrevListTitle(stringResource(route_name__stories))
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { StoriesError() }
                is Loading -> item { StoriesLoading() }
                is Success -> {
                    item { Button(onLoadMore) {} }
                }
            }
        }
    }
}

private fun LazyListScope.list(list: List<StoryPreview>) {
    items(list) { StoryPrev(it) }
}

@Composable
private fun StoryPrev(data: StoryPreview) {
    PrevOnInfoSuccess(data.title, data.image)
}

@Composable
private fun StoriesError(modifier: Modifier = Modifier) {
    PrevOnInfoError(modifier)
}

@Composable
private fun StoriesLoading(modifier: Modifier = Modifier) {
    Row(modifier) {
        PrevOnInfoLoading()
        PrevOnInfoLoading()
        PrevOnInfoLoading()
    }
}