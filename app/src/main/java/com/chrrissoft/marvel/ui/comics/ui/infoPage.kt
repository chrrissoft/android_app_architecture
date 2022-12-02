package com.chrrissoft.marvel.ui.comics.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.ui.comics.res.ComicRes
import com.chrrissoft.marvel.ui.comics.res.ComicResState.*
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.CharsPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.EventsPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.SeriesPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.StoriesPreviewsInInfo

@Composable
fun ComicsInfoPage(
    res: Comic,
    modifier: Modifier = Modifier,
    onLoadChars: () -> Unit,
    onLoadSeries: () -> Unit,
    onLoadStories: () -> Unit,
    onLoadEvents: () -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
            .verticalScroll(rememberScrollState())
    ) {
        Info(res.self)
        Spacer(Modifier.height(5.dp))
        CharsPreviewsInInfo(res.characters) { }
        SeriesPreviewsInInfo(res.series) { }
        StoriesPreviewsInInfo(res.stories) { }
        EventsPreviewsInInfo(res.events) { }
    }
}

@Composable
private fun Info(res: ComicRes) {
    when (res.state) {
        is Error -> ErrorInfo()
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.title)
    }
}
