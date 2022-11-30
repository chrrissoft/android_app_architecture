package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.comics.Comic
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class ComicsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteComicsDataSource,
    private val localDataSource: LocalComicsDataSource,
) : ComicsRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getInfo(id: Int, requestOf: ComicsRepo.RequestOf, source: Source): Flow<Comic> {
        return emptyFlow()
    }

    override fun getPreviews(source: Source): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

}