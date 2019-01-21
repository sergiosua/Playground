package com.example.sergiosuarez.newarchexample

import com.example.sergiosuarez.newarchexample.hero.HeroesPresenter
import org.koin.dsl.module.module

class AppModules {

    companion object {
        val modules = module {
            factory { HeroesPresenter(it[0], get(), get(), get(), get()) }
        }
    }

}