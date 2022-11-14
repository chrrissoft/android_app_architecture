package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse


interface SeriesRepo {

    fun getFromLocal() : SeriesResponse
    fun getFromRemote() : SeriesResponse

    fun getPreviewFromRemote() : SeriesPrevResponse
    fun getPreviewFromLocal() : SeriesPrevResponse

    fun getComicsFromRemote() : ComicsPrevResponse
    fun getComicsFromLocal() : ComicsPrevResponse

    fun getEventsFromRemote() : EventsPrevResponse
    fun getEventsFromLocal() : EventsPrevResponse

    fun getStoriesFromRemote() : StoriesPrevResponse
    fun getStoriesFromLocal() : StoriesPrevResponse

    fun getCharactersFromRemote() : CharsPrevResponse
    fun getCharactersFromLocal() : CharsPrevResponse

}