package com.chrrissoft.marvel.framework.series.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalSeriesDataSourceImpl @Inject constructor(

) : LocalSeriesDataSource {
    override fun getPreview(): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        return emptyFlow()
    }


    override fun getStories(): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getComics(): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        return emptyFlow()
    }

}






