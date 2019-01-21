package com.example.remotedatastore.hero

import com.example.data.stores.HeroRemoteDataStore
import com.example.model.Hero
import com.example.model.HeroElement
import io.reactivex.Single

class HeroRemoteDataStoreImpl(private val webService: HeroWebService) : HeroRemoteDataStore {

    override fun getHeroes(page: Int): Single<List<Hero>?> {
        return Single.fromCallable {
            webService.api.getHeroes(
                limit = HeroWebService.HEROES_PER_PAGE * page,
                offset = HeroWebService.HEROES_PER_PAGE * (page - 1),
                ts = webService.params()["ts"]?.toLong() ?: 1L,
                apiKey = webService.params()["apikey"] ?: "unspecified",
                hash = webService.params()["hash"] ?: "unspecified"
            ).execute().body()?.data?.heroes?.map { it as Hero }
        }
    }

    override fun getHero(id: Int): Single<Hero?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComics(id: Int): Single<List<HeroElement>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEvents(id: Int): Single<List<HeroElement>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStories(id: Int): Single<List<HeroElement>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSeries(id: Int): Single<List<HeroElement>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}