package com.example.localdatastore.hero

import com.example.data.stores.HeroLocalDataStore
import com.example.model.Hero
import io.reactivex.Completable
import io.reactivex.Flowable

class HeroLocalDataStoreImpl(private val dao: FavoriteDao) : HeroLocalDataStore {

    override fun getHeroes(): Flowable<List<Hero>?> =
        dao.getFavorites().map { list -> list.map { hero -> hero as Hero } }

    override fun getHero(id: Int): Flowable<Hero?> = dao.getFavoriteById(id).map { it as Hero }

    override fun insertHero(hero: Hero) = Completable.fromAction {
        try {
            dao.insertFavorite(
                Favorite(
                    hero.id,
                    hero.name,
                    hero.photo,
                    hero.description,
                    hero.resourceUri
                )
            )
        } catch (e: Exception) {
            //TODO
        }
    }!!

    override fun deleteHero(hero: Hero) = Completable.fromAction {
        dao.deleteFavorite(
            Favorite(
                hero.id,
                hero.name,
                hero.photo,
                hero.description,
                hero.resourceUri
            )
        )
    }!!
}