package com.example.remotedatastore

import com.example.data.stores.HeroRemoteDataStore
import com.example.remotedatastore.hero.HeroRemoteDataStoreImpl
import com.example.remotedatastore.hero.HeroWebService
import org.koin.dsl.module.module

class RemoteDataStoreModules {

    companion object {

        val modules = module {
            single { HeroWebService() }
            single<HeroRemoteDataStore> { HeroRemoteDataStoreImpl(get()) }
        }

    }

}