package com.chrrissoft.marvel.ui.data.chars

import androidx.lifecycle.ViewModel
import com.chrrissoft.marvel.usecases.chars.GetCharUseCase
import com.chrrissoft.marvel.usecases.chars.GetCharsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CharsViewModel(
    private val getCharacterInfoUseCase: GetCharUseCase,
    private val getCharsPrevUseCase: GetCharsPrevUseCase
) : ViewModel() {
}