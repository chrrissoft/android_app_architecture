package com.chrrissoft.marvel.framework.comics.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteComicsDataSourceImp @Inject constructor(
) : RemoteComicsDataSource {

    override fun getPreview(): Flow<ComicsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getStories(): Flow<StoriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        TODO("Not yet implemented")
    }

}
