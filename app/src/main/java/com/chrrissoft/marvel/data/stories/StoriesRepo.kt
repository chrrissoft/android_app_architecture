package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse


interface StoriesRepo {

    fun getFromLocal() : StoriesResponse
    fun getFromRemote() : StoriesResponse

    fun getPreviewFromRemote() : StoriesPrevResponse
    fun getPreviewFromLocal() : StoriesPrevResponse

    fun getEventsFromRemote() : EventsPrevResponse
    fun getEventsFromLocal() : EventsPrevResponse

    fun getCharactersFromRemote() : CharsPrevResponse
    fun getCharactersFromLocal() : CharsPrevResponse

    fun getSeriesFromRemote() : SeriesPrevResponse
    fun getSeriesFromLocal() : SeriesPrevResponse

    fun getComicsFromRemote() : ComicsPrevResponse
    fun getComicsFromLocal() : ComicsPrevResponse

}