package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes


interface EventsRepo {

    fun getFromLocal() : EventRes
    fun getFromRemote() : EventRes

    fun getPreviewFromRemote() : EventsPrevRes
    fun getPreviewFromLocal() : EventsPrevRes

    fun getComicsFromRemote() : ComicsPrevRes
    fun getComicsFromLocal() : ComicsPrevRes

    fun getStoriesFromRemote() : StoriesPrevRes
    fun getStoriesFromLocal() : StoriesPrevRes

    fun getCharactersFromRemote() : CharsPrevRes
    fun getCharactersFromLocal() : CharsPrevRes

    fun getSeriesFromRemote() : SeriesPrevRes
    fun getSeriesFromLocal() : SeriesPrevRes

}