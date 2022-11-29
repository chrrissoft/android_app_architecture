package com.chrrissoft.marvel.data.chars.res

import com.chrrissoft.marvel.ui.chars.res.CharsRes as UiCharsRes
import com.chrrissoft.marvel.ui.chars.res.CharResState.Error as UiError
import com.chrrissoft.marvel.ui.chars.res.CharResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.chars.res.CharResState.Success as UiSuccess
import com.chrrissoft.marvel.data.chars.res.CharResState.Error as DataError
import com.chrrissoft.marvel.data.chars.res.CharResState.Loading as DataLoading
import com.chrrissoft.marvel.data.chars.res.CharResState.Success as DataSuccess


fun charConverter(res: CharRes): UiCharsRes {
    return when (res.state) {
        is DataError -> UiCharsRes(UiError(res.state.message))
        is DataLoading -> UiCharsRes(UiLoading(res.state.message))
        is DataSuccess -> UiCharsRes(UiSuccess(res.state.id, res.state.name, res.state.image))
    }
}