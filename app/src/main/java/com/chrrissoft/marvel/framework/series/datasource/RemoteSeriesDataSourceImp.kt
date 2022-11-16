package com.chrrissoft.marvel.framework.series.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteSeriesDataSourceImp @Inject constructor(
) : RemoteSeriesDataSource {

    override fun getPreview(): Flow<SeriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getStories(): Flow<StoriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getComics(): Flow<ComicsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        TODO("Not yet implemented")
    }

}
