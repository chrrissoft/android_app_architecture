package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse


interface ComicsRepo {

    fun getFromLocal() : ComicsResponse
    fun getFromRemote() : ComicsResponse

    fun getPreviewFromRemote() : ComicsPrevResponse
    fun getPreviewFromLocal() : ComicsPrevResponse

    fun getEventsFromRemote() : EventsPrevResponse
    fun getEventsFromLocal() : EventsPrevResponse

    fun getStoriesFromRemote() : StoriesPrevResponse
    fun getStoriesFromLocal() : StoriesPrevResponse

    fun getCharactersFromRemote() : CharsPrevResponse
    fun getCharactersFromLocal() : CharsPrevResponse

    fun getSeriesFromRemote() : SeriesPrevResponse
    fun getSeriesFromLocal() : SeriesPrevResponse

}