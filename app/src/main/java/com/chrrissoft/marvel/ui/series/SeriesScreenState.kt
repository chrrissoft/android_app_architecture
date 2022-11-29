package com.chrrissoft.marvel.ui.series

import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes

data class SeriesScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Serie = Serie.emptySerie,
    val previews: SeriesPrevRes = SeriesPrevRes(),
)
