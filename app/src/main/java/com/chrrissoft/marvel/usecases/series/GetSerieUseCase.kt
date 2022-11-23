package com.chrrissoft.marvel.usecases.series

import com.chrrissoft.marvel.data.series.SeriesRepo
import javax.inject.Inject

class GetSerieUseCase @Inject constructor(
    private val repo: SeriesRepo,
) {
    operator fun invoke(id: Int) {}
}

