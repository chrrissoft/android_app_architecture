package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalStoriesDataSourceImpl @Inject constructor(

) : LocalStoriesDataSource {

    override fun getComics(): Flow<ComicsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getPreview(): Flow<StoriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        TODO("Not yet implemented")
    }


}






