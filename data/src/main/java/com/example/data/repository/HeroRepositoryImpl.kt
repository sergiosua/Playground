package com.example.data.repository

import com.example.data.stores.HeroLocalDataStore
import com.example.data.stores.HeroRemoteDataStore
import com.example.domain.HeroRepository
import com.example.model.Hero
import com.example.model.HeroElement
import io.reactivex.Flowable
import io.reactivex.Single

class HeroRepositoryImpl(
    private val localDataStore: HeroLocalDataStore,
    private val remoteDataStore: HeroRemoteDataStore
) : HeroRepository {

    override fun getHeroes(page: Int): Single<List<Hero>?> = remoteDataStore.getHeroes(page)

    override fun getFavorites(): Flowable<List<Hero>?> = localDataStore.getHeroes()

    override fun getHero(characterId: Int): Single<Hero?> = remoteDataStore.getHero(characterId)

    override fun getFavorite(characterId: Int): Flowable<Hero?> = localDataStore.getHero(characterId)

    override fun getComics(characterId: Int): Single<List<HeroElement>?> = remoteDataStore.getComics(characterId)

    override fun getEvents(characterId: Int): Single<List<HeroElement>?> = remoteDataStore.getEvents(characterId)

    override fun getStories(characterId: Int): Single<List<HeroElement>?> = remoteDataStore.getStories(characterId)

    override fun getSeries(characterId: Int): Single<List<HeroElement>?> = remoteDataStore.getSeries(characterId)

    override fun createFavoriteHero(hero: Hero) = localDataStore.insertHero(hero)

    override fun deleteFavoriteHero(hero: Hero) = localDataStore.deleteHero(hero)

}