package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import javax.inject.Inject

class GetCharUseCase @Inject constructor(
    private val repo: CharsRepo,
) {
    suspend operator fun invoke(id: Int) {}
}

