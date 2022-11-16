package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes


interface SeriesRepo {

    fun getFromLocal() : SerieRes
    fun getFromRemote() : SerieRes

    fun getPreviewFromRemote() : SeriesPrevRes
    fun getPreviewFromLocal() : SeriesPrevRes

    fun getComicsFromRemote() : ComicsPrevRes
    fun getComicsFromLocal() : ComicsPrevRes

    fun getEventsFromRemote() : EventsPrevRes
    fun getEventsFromLocal() : EventsPrevRes

    fun getStoriesFromRemote() : StoriesPrevRes
    fun getStoriesFromLocal() : StoriesPrevRes

    fun getCharactersFromRemote() : CharsPrevRes
    fun getCharactersFromLocal() : CharsPrevRes

}