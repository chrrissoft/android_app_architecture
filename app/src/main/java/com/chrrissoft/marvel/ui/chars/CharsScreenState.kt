package com.chrrissoft.marvel.ui.chars

import com.chrrissoft.marvel.ui.chars.CharsScreenState.PreviewResState.LOADING as PREVIEW_LOADING
import com.chrrissoft.marvel.ui.chars.CharsScreenState.InfoResState.LOADING as INFO_LOADING
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class CharsScreenState(
    val previewResState: PreviewResState = PREVIEW_LOADING,
    val infoResState: InfoResState = INFO_LOADING,
    val screenPage: ScreenPage = PREVIEW,
    val info: Character = Character.emptyChar,
    val previews: List<CharsPreview> = emptyList(),
) {
    enum class PreviewResState {
        LOADING, ERROR, SUCCESS
    }

    enum class InfoResState {
        LOADING, ERROR, SUCCESS
    }
}