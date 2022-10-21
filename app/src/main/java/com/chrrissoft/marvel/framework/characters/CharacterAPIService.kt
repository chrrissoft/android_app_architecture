package com.chrrissoft.marvel.framework.characters

import com.chrrissoft.marvel.framework.characters.models.info.CharacterInfoAPIResponse
import com.chrrissoft.marvel.framework.characters.models.preview.CharactersPreviewAPIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterAPIService {

    private companion object {
        const val TS = "ts=1428956&"
        const val APIKEY = "apikey=04897d6c970cdeab2011aec174b2ad6d&"
        const val HASH = "hash=f1dfe54e17c6fd558915df011207dd27"
        const val ENDPOINT = "v1/public/characters?"
        private const val RES = "$ENDPOINT$TS$APIKEY$HASH"
    }

    @GET(RES)
    suspend fun getAll(): Response<CharactersPreviewAPIResponse>

    @GET("")
    suspend fun getById(@Path("id") id: Int) : Response<CharacterInfoAPIResponse>
}
