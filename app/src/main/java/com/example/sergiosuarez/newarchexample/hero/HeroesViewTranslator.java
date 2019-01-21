package com.example.sergiosuarez.newarchexample.hero;

import java.util.List;

public interface HeroesViewTranslator {

    void loadPage(final int page);

    void loadFavorites();

    void showLoader(final boolean shouldShow);

    void updateContent(final List<Hero> heroes);

    void showListLoader();

    void hideListLoader();

    void markAsFavorite(Hero hero);

    void unmarkAsFavorite(Hero hero);

    //void enableSearch();

    //void disableSearch();

    void disableEndlessListener();

    void showEndReached();

    //fun openDetailScreen(hero: Hero);

}
