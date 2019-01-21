package com.example.domain.favorite;

import com.example.domain.CompletableUseCase;
import com.example.domain.HeroRepository;
import com.example.model.Hero;
import io.reactivex.Completable;

public class CreateFavoriteUseCase implements CompletableUseCase<CreateFavoriteUseCase.Query> {

    public static final class Query {

        final Hero hero;

        public Query(Hero hero) {
            this.hero = hero;
        }
    }

    private HeroRepository mHeroRepository;

    public CreateFavoriteUseCase(HeroRepository mHeroRepository) {
        this.mHeroRepository = mHeroRepository;
    }

    @Override
    public Completable execute(Query query) {
        return mHeroRepository.createFavoriteHero(query.hero);
    }

}
