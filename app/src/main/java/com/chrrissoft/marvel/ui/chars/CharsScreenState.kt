package com.chrrissoft.marvel.ui.chars

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class CharsScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val previews: CharsPrevRes = CharsPrevRes(),
    val info: Character = Character.emptyChar,
)
