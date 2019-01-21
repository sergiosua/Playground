package com.example.remotedatastore.hero

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroApi {

    @GET("characters")
    fun getHeroes(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Call<DataDto<HeroDto>>


    @GET("characters/{characterId}")
    fun getHero(
        @Path("characterId") characterId: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Single<DataDto<HeroDto>>

    @GET("characters/{characterId}/comics")
    fun getComics(
        @Path("characterId") characterId: Int,
        @Query("limit") limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Single<DataDto<ComicDto>>

    @GET("characters/{characterId}/events")
    fun getEvents(
        @Path("characterId") characterId: Int,
        @Query("limit") limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Single<DataDto<EventDto>>

    @GET("characters/{characterId}/stories")
    fun getStories(
        @Path("characterId") characterId: Int,
        @Query("limit") limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Single<DataDto<StoryDto>>

    @GET("characters/{characterId}/series")
    fun getSeries(
        @Path("characterId") characterId: Int,
        @Query("limit") limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Single<DataDto<SerieDto>>

}