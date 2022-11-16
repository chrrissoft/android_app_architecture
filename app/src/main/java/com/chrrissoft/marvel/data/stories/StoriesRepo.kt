package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes


interface StoriesRepo {

    fun getFromLocal() : StoryRes
    fun getFromRemote() : StoryRes

    fun getPreviewFromRemote() : StoriesPrevRes
    fun getPreviewFromLocal() : StoriesPrevRes

    fun getEventsFromRemote() : EventsPrevRes
    fun getEventsFromLocal() : EventsPrevRes

    fun getCharactersFromRemote() : CharsPrevRes
    fun getCharactersFromLocal() : CharsPrevRes

    fun getSeriesFromRemote() : SeriesPrevRes
    fun getSeriesFromLocal() : SeriesPrevRes

    fun getComicsFromRemote() : ComicsPrevRes
    fun getComicsFromLocal() : ComicsPrevRes

}