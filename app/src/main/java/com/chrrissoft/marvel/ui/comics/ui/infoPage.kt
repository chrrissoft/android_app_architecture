package com.chrrissoft.marvel.ui.comics.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.marvel.ui.INFO_STATE
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.ui.comics.res.ComicRes
import com.chrrissoft.marvel.ui.comics.res.ComicResState.*
import com.chrrissoft.marvel.ui.common.info.EmptyInfo
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.*

@Composable
fun ComicsInfoPage(
    res: Comic,
    modifier: Modifier = Modifier,
    onLoadComic: () -> Unit,
    onLoadChars: () -> Unit,
    onLoadSeries: () -> Unit,
    onLoadStories: () -> Unit,
    onLoadEvents: () -> Unit,
) {

    if (res.isEmpty()) EmptyInfo()

    else {
        Column(
            modifier
                .fillMaxSize()
                .background(colorScheme.secondaryContainer)
                .verticalScroll(rememberScrollState())
        ) {
            Info(res.self) { onLoadComic() }
            Spacer(Modifier.height(5.dp))
            CharsPreviewsInInfo(res.characters) { onLoadChars() }
            SeriesPreviewsInInfo(res.series) { onLoadSeries() }
            StoriesPreviewsInInfo(res.stories) { onLoadStories() }
            EventsPreviewsInInfo(res.events) { onLoadEvents() }
        }
    }
}

@Composable
private fun Info(res: ComicRes, onTryAgain: () -> Unit) {
    Log.d(INFO_STATE, "Comic info   ->   ${res.state}")
    when (res.state) {
        is Error -> ErrorInfo { onTryAgain() }
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.title, res.state.image)
    }
}
