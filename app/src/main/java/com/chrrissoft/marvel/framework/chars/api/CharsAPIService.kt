package com.chrrissoft.marvel.framework.chars.api

import com.chrrissoft.marvel.framework.comics.api.Comics
import com.chrrissoft.marvel.framework.events.api.Events
import com.chrrissoft.marvel.framework.series.api.Series
import com.chrrissoft.marvel.framework.stories.api.Stories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharsAPIService {

    private companion object {
        private const val TS = "ts=1428956"
        private const val APIKEY = "&apikey=04897d6c970cdeab2011aec174b2ad6d"
        private const val HASH = "&hash=f1dfe54e17c6fd558915df011207dd27"
    }

    @GET("v1/public/characters/{id}?$TS$APIKEY$HASH")
    suspend fun getChar(@Path("id") id: Int): Response<Characters>

    @GET("v1/public/characters?$TS$APIKEY$HASH")
    suspend fun getChars(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<Characters>

    @GET("v1/public/characters/{id}/comics?$TS$APIKEY$HASH")
    suspend fun getComics(
        @Path("id") id: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<Comics>

    @GET("v1/public/characters/{id}/series?$TS$APIKEY$HASH")
    suspend fun getSeries(
        @Path("id") id: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<Series>

    @GET("v1/public/characters/{id}/stories?$TS$APIKEY$HASH")
    suspend fun getStories(
        @Path("id") id: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<Stories>

    @GET("v1/public/characters/{id}/events?$TS$APIKEY$HASH")
    suspend fun getEvents(
        @Path("id") id: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<Events>

}
