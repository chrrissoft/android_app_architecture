package com.chrrissoft.marvel.framework.characters

import com.chrrissoft.marvel.data.characters.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.characters.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.characters.CharacterResponse
import com.chrrissoft.marvel.data.characters.CharactersRepo
import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharactersRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): CharacterResponse {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): CharacterResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): CharsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): CharsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromRemote(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromRemote(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromLocal(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromRemote(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromLocal(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromRemote(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromLocal(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }

}