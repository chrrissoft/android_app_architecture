package com.chrrissoft.marvel.ui.chars

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO

data class CharsScreenState(
    val screenPage: ScreenPage = INFO,
    val previews: CharsPrevRes = CharsPrevRes(),
    val info: Character = Character.emptyChar,
)
