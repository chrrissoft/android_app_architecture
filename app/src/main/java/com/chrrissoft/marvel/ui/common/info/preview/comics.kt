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
import com.chrrissoft.marvel.R.string.route_name__comics
import com.chrrissoft.marvel.ui.INFO_STATE
import com.chrrissoft.marvel.ui.comics.ComicsPreview
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.*
import com.chrrissoft.marvel.ui.common.info.PrevListTitle
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoError
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoLoading
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoSuccess

@Composable
fun ComicsPreviewsInInfo(
    res: ComicsPrevRes,
    modifier: Modifier = Modifier,
    onLoadMore: () -> Unit
) {
    Log.d(INFO_STATE, "Comics on info   ->   ${res.state}")
    Column(modifier) {
        PrevListTitle(stringResource(route_name__comics))
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { ComicsError() }
                is Loading -> item { ComicsLoading() }
                is Success -> {
                    item { Button(onLoadMore) {} }
                }
            }
        }
    }
}

private fun LazyListScope.list(list: List<ComicsPreview>) {
    items(list) { ComicsPrev(it) }
}

@Composable
private fun ComicsPrev(data: ComicsPreview) {
    PrevOnInfoSuccess(data.title, data.image)
}

@Composable
private fun ComicsError(modifier: Modifier = Modifier) {
    PrevOnInfoError(modifier)
}

@Composable
private fun ComicsLoading(modifier: Modifier = Modifier) {
    Row(modifier) {
        PrevOnInfoLoading()
        PrevOnInfoLoading()
        PrevOnInfoLoading()
    }
}