package com.chrrissoft.marvel.ui.chars.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.marvel.ui.chars.Character
import com.chrrissoft.marvel.ui.chars.res.CharResState
import com.chrrissoft.marvel.ui.chars.res.CharResState.*
import com.chrrissoft.marvel.ui.chars.res.CharsRes
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.ComicsPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.EventsPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.SeriesPreviewsInInfo
import com.chrrissoft.marvel.ui.common.info.preview.StoriesPreviewsInInfo

@Composable
fun CharInfoPage(
    res: Character,
    modifier: Modifier = Modifier,
    onLoadMore: () -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
            .verticalScroll(rememberScrollState())
    ) {
        Info(res.self)
        Spacer(Modifier.height(5.dp))
        ComicsPreviewsInInfo(res.comics) { }
        SeriesPreviewsInInfo(res.series) { }
        StoriesPreviewsInInfo(res.stories) { }
        EventsPreviewsInInfo(res.events) { }
    }
}

@Composable
private fun Info(res: CharsRes) {
    when (res.state) {
        is Error -> ErrorInfo()
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.name)
    }
}
