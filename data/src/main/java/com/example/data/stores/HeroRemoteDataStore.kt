package com.example.data.stores

import com.example.model.Hero
import com.example.model.HeroElement
import io.reactivex.Single

interface HeroRemoteDataStore {

    fun getHeroes(page: Int): Single<List<Hero>?>

    fun getHero(id: Int): Single<Hero?>

    fun getComics(id: Int): Single<List<HeroElement>?>

    fun getEvents(id: Int): Single<List<HeroElement>?>

    fun getStories(id: Int): Single<List<HeroElement>?>

    fun getSeries(id: Int): Single<List<HeroElement>?>

}