package com.chrrissoft.marvel.usecases.events

import com.chrrissoft.marvel.data.events.EventsRepo
import javax.inject.Inject

class GetEventUseCase @Inject constructor(
    private val repo: EventsRepo,
) {
    operator fun invoke(id: Int) {}
}

