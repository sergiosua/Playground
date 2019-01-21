package com.example.domain;

import com.example.model.Hero;
import com.example.model.HeroElement;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

import java.util.List;

public interface HeroRepository {

    @NonNull
    Single<List<Hero>> getHeroes(@NonNull final int page);

    @NonNull
    Flowable<List<Hero>> getFavorites();

    @NonNull
    Single<Hero> getHero(@NonNull final int characterId);

    @NonNull
    Flowable<Hero> getFavorite(@NonNull final int characterId);

    @NonNull
    Single<List<HeroElement>> getComics(@NonNull final int characterId);

    @NonNull
    Single<List<HeroElement>> getEvents(@NonNull final int characterId);

    @NonNull
    Single<List<HeroElement>> getStories(@NonNull final int characterId);

    @NonNull
    Single<List<HeroElement>> getSeries(@NonNull final int characterId);

    Completable createFavoriteHero(@NonNull final Hero hero);

    Completable deleteFavoriteHero(@NonNull final Hero hero);

}
