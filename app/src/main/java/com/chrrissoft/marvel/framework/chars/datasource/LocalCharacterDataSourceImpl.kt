package com.chrrissoft.marvel.framework.chars.datasource

import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalCharacterDataSourceImpl @Inject constructor(

) : LocalCharacterDataSource {
    override fun get(id: Int): Flow<CharsPreview> {
        return emptyFlow()
    }

    override fun getPreviews(): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun getComics(id: Int): Flow<ComicsPrevRes> {
        return emptyFlow()
    }


    override fun getSeries(id: Int): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getStories(id: Int): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getEvents(id: Int): Flow<EventsPrevRes> {
        return emptyFlow()
    }


}






