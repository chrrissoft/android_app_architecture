package com.chrrissoft.marvel.usecases.comics

import com.chrrissoft.marvel.data.comics.ComicsRepo
import javax.inject.Inject

class GetComicUseCase @Inject constructor(
    private val repo: ComicsRepo,
) {
    suspend fun init() {

    }
}

