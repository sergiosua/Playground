package com.example.domain

import com.example.domain.favorite.CreateFavoriteUseCase
import com.example.domain.favorite.DeleteFavoriteUseCase
import com.example.domain.favorite.GetFavoritesUseCase
import com.example.domain.search.SearchUseCase
import org.koin.dsl.module.module

class DomainModules {

    companion object {

        val modules = module {
            single { SearchUseCase(get()) }
            single { GetFavoritesUseCase(get()) }
            single { CreateFavoriteUseCase(get()) }
            single { DeleteFavoriteUseCase(get()) }
        }

    }
}