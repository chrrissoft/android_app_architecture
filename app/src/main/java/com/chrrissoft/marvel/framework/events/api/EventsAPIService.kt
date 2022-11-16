package com.chrrissoft.marvel.framework.events.api

import com.chrrissoft.marvel.framework.chars.api.Characters
import retrofit2.Response
import retrofit2.http.GET

interface EventsAPIService {

    private companion object {
        const val TS = "ts=1428956&"
        const val APIKEY = "apikey=04897d6c970cdeab2011aec174b2ad6d&"
        const val HASH = "hash=f1dfe54e17c6fd558915df011207dd27"
        const val ENDPOINT = "v1/public/events?"
        private const val PREVIEW = "$ENDPOINT$TS$APIKEY$HASH"
    }

    @GET(PREVIEW)
    suspend fun getPreview(): Response<Events>

    @GET("")
    suspend fun getCharacters(id: Int) : Response<Characters>
}
