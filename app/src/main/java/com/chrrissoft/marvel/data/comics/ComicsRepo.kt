package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes


interface ComicsRepo {

    fun getFromLocal() : ComicRes
    fun getFromRemote() : ComicRes

    fun getPreviewFromRemote() : ComicsPrevRes
    fun getPreviewFromLocal() : ComicsPrevRes

    fun getEventsFromRemote() : EventsPrevRes
    fun getEventsFromLocal() : EventsPrevRes

    fun getStoriesFromRemote() : StoriesPrevRes
    fun getStoriesFromLocal() : StoriesPrevRes

    fun getCharactersFromRemote() : CharsPrevRes
    fun getCharactersFromLocal() : CharsPrevRes

    fun getSeriesFromRemote() : SeriesPrevRes
    fun getSeriesFromLocal() : SeriesPrevRes

}