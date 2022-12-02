package com.chrrissoft.marvel.ui.common.info.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.common.info.PrevListTitle
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoError
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoLoading
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoSuccess
import com.chrrissoft.marvel.R.string.route_name__stories
import com.chrrissoft.marvel.ui.chars.CharsPreview
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.*

@Composable
fun CharsPreviewsInInfo(res: CharsPrevRes, onLoadMore: () -> Unit) {
    Column {
        PrevListTitle(stringResource(route_name__stories))
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { CharsError() }
                is Loading -> item { CharsLoading() }
                is Success -> { item { Button(onClick = { onLoadMore() }) {} } }
            }
        }
    }
}

private fun LazyListScope.list(list: List<CharsPreview>) {
    items(list) { CharPrev(it) }
}

@Composable
private fun CharPrev(data: CharsPreview) {
    PrevOnInfoSuccess(data.name, data.image)
}

@Composable
private fun CharsError() {
    PrevOnInfoError()
}

@Composable
private fun CharsLoading() {
    Column {
        PrevOnInfoLoading()
        PrevOnInfoLoading()
        PrevOnInfoLoading()
    }
}