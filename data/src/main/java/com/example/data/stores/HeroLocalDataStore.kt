package com.example.data.stores

import com.example.model.Hero
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface HeroLocalDataStore {

    fun getHeroes(): Flowable<List<Hero>?>

    fun getHero(id: Int): Flowable<Hero?>

    fun insertHero(hero: Hero): Completable

    fun deleteHero(hero: Hero): Completable

}