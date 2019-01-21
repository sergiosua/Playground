package com.example.data

import com.example.data.repository.HeroRepositoryImpl
import com.example.domain.HeroRepository
import org.koin.dsl.module.module

class DataModules {

    companion object {

        val modules = module {
            single<HeroRepository> { HeroRepositoryImpl(get(), get()) }
        }

    }

}