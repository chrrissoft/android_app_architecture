package com.chrrissoft.marvel.ui.common.info.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.ui.series.SeriesPreview
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.common.info.PrevListTitle
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoError
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoLoading
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoSuccess
import com.chrrissoft.marvel.R.string.route_name__series
import com.chrrissoft.marvel.ui.series.res.SeriesPrevResState.*

@Composable
fun SeriesPreviewsInInfo(
    res: SeriesPrevRes,
    modifier: Modifier = Modifier,
    onLoadMore: () -> Unit,
) {
    Column(modifier) {
        PrevListTitle(stringResource(route_name__series))
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { SeriesError() }
                is Loading -> item { SeriesLoading() }
                is Success -> {
                    item { Button(onLoadMore) {} }
                }
            }
        }
    }
}

private fun LazyListScope.list(list: List<SeriesPreview>) {
    items(list) { SeriesPrev(it) }
}

@Composable
private fun SeriesPrev(data: SeriesPreview) {
    PrevOnInfoSuccess(data.title, data.image)
}

@Composable
private fun SeriesError(modifier: Modifier = Modifier) {
    PrevOnInfoError(modifier)
}

@Composable
private fun SeriesLoading(modifier: Modifier = Modifier) {
    Row(modifier) {
        PrevOnInfoLoading()
        PrevOnInfoLoading()
        PrevOnInfoLoading()
    }
}