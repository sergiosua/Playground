package com.example.localdatastore

import android.content.Context
import com.example.data.stores.HeroLocalDataStore
import com.example.localdatastore.hero.HeroLocalDataStoreImpl
import org.koin.dsl.module.module


class LocalDataStoreModules(context: Context) {

    val modules = module {
        single { MarvelDatabase.getInstance(context).getFavoriteDao() }
        single<HeroLocalDataStore> { HeroLocalDataStoreImpl(get()) }
    }

}