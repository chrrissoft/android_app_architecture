package com.chrrissoft.marvel.ui.chars.ui

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
import com.chrrissoft.marvel.ui.chars.Character
import com.chrrissoft.marvel.ui.chars.res.CharResState.*
import com.chrrissoft.marvel.ui.chars.res.CharsRes
import com.chrrissoft.marvel.ui.common.info.EmptyInfo
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.*

@Composable
fun CharInfoPage(
    res: Character,
    modifier: Modifier = Modifier,
    onLoadComics: () -> Unit,
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
            Info(res.self)
            Spacer(Modifier.height(5.dp))
            ComicsPreviewsInInfo(res.comics) { onLoadComics() }
            SeriesPreviewsInInfo(res.series) { onLoadSeries() }
            StoriesPreviewsInInfo(res.stories) { onLoadStories() }
            EventsPreviewsInInfo(res.events) { onLoadEvents() }
        }
    }
}

@Composable
private fun Info(res: CharsRes) {
    Log.d(INFO_STATE, "Char info   ->   ${res.state}")
    when (res.state) {
        is Error -> ErrorInfo()
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.name)
    }
}
