package com.example.sergiosuarez.newarchexample.hero;

import com.example.domain.favorite.CreateFavoriteUseCase;
import com.example.domain.favorite.DeleteFavoriteUseCase;
import com.example.domain.favorite.GetFavoritesUseCase;
import com.example.domain.search.SearchUseCase;
import com.example.sergiosuarez.newarchexample.adapter.OnLimitReachedListener;
import io.reactivex.Observable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class HeroesPresenter implements OnLimitReachedListener {

    private WeakReference<HeroesViewTranslator> viewTranslator;
    private SearchUseCase mSearchUseCase;
    private GetFavoritesUseCase mGetFavoritesUseCase;
    private CreateFavoriteUseCase mCreateFavoriteUseCase;
    private DeleteFavoriteUseCase mDeleteFavoriteUseCase;

    private List<Hero> heroes = new ArrayList<>();
    private List<Hero> favorites = new ArrayList<>();
    private int currentPage = 1;

    public HeroesPresenter(HeroesViewTranslator viewTranslator,
                           SearchUseCase mSearchUseCase,
                           GetFavoritesUseCase mGetFavoritesUseCase,
                           CreateFavoriteUseCase mCreateFavoriteUseCase,
                           DeleteFavoriteUseCase mDeleteFavoriteUseCase) {
        this.viewTranslator = new WeakReference<>(viewTranslator);
        this.mSearchUseCase = mSearchUseCase;
        this.mGetFavoritesUseCase = mGetFavoritesUseCase;
        this.mCreateFavoriteUseCase = mCreateFavoriteUseCase;
        this.mDeleteFavoriteUseCase = mDeleteFavoriteUseCase;
    }

    private HeroesViewTranslator getViewTranslator() {
        return viewTranslator.get();
    }

    public void onCreated() {
        getViewTranslator().loadFavorites();
        getViewTranslator().loadPage(currentPage);
    }

    public void onHeroClicked(Hero hero) {
        //TODO
    }

    public void onFavoriteClicked(Hero hero) {
        if (hero.isFavorite()) {
            getViewTranslator().unmarkAsFavorite(hero);
        } else {
            getViewTranslator().markAsFavorite(hero);
        }
    }

    public void onSearch(String text) {
        //TODO
    }

    @Override
    public void onPageLimitReachedListener() {
        getViewTranslator().loadPage(currentPage);
    }

    Observable<List<Hero>> startSearch(final int page) {
        return mSearchUseCase.execute(new SearchUseCase.Query(page))
                .map(result -> {
                            heroes.addAll(HeroKt.mapToUI(result));
                            currentPage++;
                            return heroes;
                        }
                )
                .toObservable();
    }

    Observable<Boolean> getFavorites() {
        return mGetFavoritesUseCase.execute(new GetFavoritesUseCase.Query())
                .map(result -> {
                            favorites = HeroKt.mapToUI(result);
                            return true;
                        }
                ).toObservable();
    }

    Observable<Boolean> setHeroAsFavorite(Hero hero) {
        return mCreateFavoriteUseCase.execute(new CreateFavoriteUseCase.Query(hero)).toObservable();
    }

    Observable<Boolean> unsetHeroAsFavorite(Hero hero) {
        return mDeleteFavoriteUseCase.execute(new DeleteFavoriteUseCase.Query(hero)).toObservable();
    }

    void updateContent() {
        HeroKt.checkFavoriteHeroes(heroes, favorites);
        getViewTranslator().updateContent(heroes);
    }

}
