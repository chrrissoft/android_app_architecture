package com.chrrissoft.marvel.ui.comics

import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class ComicsScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Comic = Comic.emptyComic,
    val previews: ComicsPrevRes = ComicsPrevRes(),
)
