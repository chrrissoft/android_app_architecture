package com.chrrissoft.marvel.framework.series

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.Serie
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class SeriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteSeriesDataSource,
    private val localDataSource: LocalSeriesDataSource,
) : SeriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getInfo(
        id: Int,
        requestOf: SeriesRepo.RequestOf,
        source: SeriesRepo.Source
    ): Flow<Serie> {
        return emptyFlow()
    }

    override fun getPreviews(source: SeriesRepo.Source): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

}