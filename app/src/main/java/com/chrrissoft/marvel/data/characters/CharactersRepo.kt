package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse


interface CharactersRepo {
    fun getFromLocal() : CharacterResponse
    fun getFromRemote() : CharacterResponse

    fun getPreviewFromRemote() : CharsPrevResponse
    fun getPreviewFromLocal() : CharsPrevResponse

    fun getComicsFromRemote() : ComicsPrevResponse
    fun getComicsFromLocal() : ComicsPrevResponse

    fun getEventsFromRemote() : EventsPrevResponse
    fun getEventsFromLocal() : EventsPrevResponse

    fun getStoriesFromRemote() : StoriesPrevResponse
    fun getStoriesFromLocal() : StoriesPrevResponse

    fun getSeriesFromRemote() : SeriesPrevResponse
    fun getSeriesFromLocal() : SeriesPrevResponse
}