package com.example.sergiosuarez.newarchexample.hero

import com.example.model.Hero as HeroModel

data class Hero(
    override val id: Int,
    override val name: String,
    override val photo: String,
    override val description: String,
    override val resourceUri: String,
    var isFavorite: Boolean = false
) : HeroModel {

    constructor(hero: HeroModel) : this(
        hero.id,
        hero.name,
        hero.photo,
        hero.description,
        hero.resourceUri
    )
}

fun mapToUI(heroes: List<HeroModel>): List<Hero> = heroes.map { Hero(it) }

fun containsHeroById(heroes: List<Hero>, id: Int) = heroes.map { it.id }.contains(id)

fun checkFavoriteHeroes(heroes: List<Hero>, favorites: List<Hero>) {
    val ids = favorites.map { it.id }
    heroes.onEach { it.isFavorite = false }.filter { ids.contains(it.id) }.map { it.isFavorite = true }
}
