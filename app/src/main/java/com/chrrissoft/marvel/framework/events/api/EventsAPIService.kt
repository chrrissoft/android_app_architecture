package com.chrrissoft.marvel.framework.events.api

import com.chrrissoft.marvel.framework.chars.api.Characters
import com.chrrissoft.marvel.framework.comics.api.ComicsAPIService
import retrofit2.Response
import retrofit2.http.GET

interface EventsAPIService {

    private companion object {
        private const val TS = "ts=1428956"
        private const val APIKEY = "&apikey=04897d6c970cdeab2011aec174b2ad6d"
        private const val HASH = "&hash=f1dfe54e17c6fd558915df011207dd27"
        private const val OFFSET = "&offset="
        private const val LIMIT = "&limit=20"
    }

    @GET("v1/public/mimics?$TS$APIKEY$HASH$OFFSET{offset}$LIMIT")
    suspend fun getPreview(): Response<Events>

    @GET("")
    suspend fun getCharacters(id: Int) : Response<Characters>
}
