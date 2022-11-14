package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse


interface EventsRepo {

    fun getFromLocal() : EventResponse
    fun getFromRemote() : EventResponse

    fun getPreviewFromRemote() : EventsPrevResponse
    fun getPreviewFromLocal() : EventsPrevResponse

    fun getComicsFromRemote() : ComicsPrevResponse
    fun getComicsFromLocal() : ComicsPrevResponse

    fun getStoriesFromRemote() : StoriesPrevResponse
    fun getStoriesFromLocal() : StoriesPrevResponse

    fun getCharactersFromRemote() : CharsPrevResponse
    fun getCharactersFromLocal() : CharsPrevResponse

    fun getSeriesFromRemote() : SeriesPrevResponse
    fun getSeriesFromLocal() : SeriesPrevResponse

}