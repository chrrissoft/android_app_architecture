package com.chrrissoft.marvel.framework.events

import com.chrrissoft.marvel.data.events.Event
import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteEventsDataSource,
    private val localDataSource: LocalEventsDataSource,
) : EventsRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getInfo(
        id: Int,
        requestOf: EventsRepo.RequestOf,
        source: EventsRepo.Source
    ): Flow<Event> {
        return emptyFlow()
    }

    override fun getPreviews(source: EventsRepo.Source): Flow<EventsPrevRes> {
        return emptyFlow()
    }

}