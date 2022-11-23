package com.chrrissoft.marvel.ui.comics

import com.chrrissoft.marvel.ui.comics.ComicsScreenState.PreviewResState.LOADING as PREVIEW_LOADING
import com.chrrissoft.marvel.ui.comics.ComicsScreenState.InfoResState.LOADING as INFO_LOADING
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class ComicsScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Comic = Comic.emptyComic,
    val infoResState: InfoResState = INFO_LOADING,
    val previews: List<ComicsPreview> = emptyList(),
    val previewResState: PreviewResState = PREVIEW_LOADING,
) {
    enum class PreviewResState {
        LOADING, ERROR, SUCCESS
    }

    enum class InfoResState {
        LOADING, ERROR, SUCCESS
    }
}