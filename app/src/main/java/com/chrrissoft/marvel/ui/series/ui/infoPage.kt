package com.chrrissoft.marvel.ui.series.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.ui.series.res.SerieRes
import com.chrrissoft.marvel.ui.series.res.SerieResState.*
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.*

@Composable
fun SerieInfoPage(
    res: Serie,
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
        CharsPreviewsInInfo(res.characters) { }
        ComicsPreviewsInInfo(res.comics) { }
        StoriesPreviewsInInfo(res.stories) { }
        EventsPreviewsInInfo(res.events) { }
    }
}

@Composable
private fun Info(res: SerieRes) {
    when (res.state) {
        is Error -> ErrorInfo()
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.title)
    }
}