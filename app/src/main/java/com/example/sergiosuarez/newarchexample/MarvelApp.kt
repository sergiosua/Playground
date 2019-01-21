package com.example.sergiosuarez.newarchexample

import android.app.Application
import com.example.data.DataModules
import com.example.domain.DomainModules
import com.example.localdatastore.LocalDataStoreModules
import com.example.remotedatastore.RemoteDataStoreModules
import org.koin.android.ext.android.startKoin

class MarvelApp : Application() {

    companion object {
        lateinit var instance: MarvelApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        val appModules = AppModules.modules
        val domainModules = DomainModules.modules
        val dataModules = DataModules.modules
        val dataStoreModules = LocalDataStoreModules(this).modules
        val remoteModules = RemoteDataStoreModules.modules

        startKoin(instance, listOf(appModules, dataStoreModules, remoteModules, dataModules, domainModules))
    }
}