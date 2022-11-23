package com.chrrissoft.marvel.ui.series

import com.chrrissoft.marvel.ui.series.SeriesScreenState.PreviewResState.LOADING as PREVIEW_LOADING
import com.chrrissoft.marvel.ui.series.SeriesScreenState.InfoResState.LOADING as INFO_LOADING
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class SeriesScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Serie = Serie.emptySerie,
    val infoResState: InfoResState = INFO_LOADING,
    val previews: List<SeriesPreview> = emptyList(),
    val previewResState: PreviewResState = PREVIEW_LOADING,
) {
    enum class PreviewResState {
        LOADING, ERROR, SUCCESS
    }

    enum class InfoResState {
        LOADING, ERROR, SUCCESS
    }
}