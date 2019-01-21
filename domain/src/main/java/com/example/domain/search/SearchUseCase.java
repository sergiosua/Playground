package com.example.domain.search;

import com.example.domain.SingleUseCase;
import com.example.domain.HeroRepository;
import com.example.model.Hero;
import io.reactivex.Single;

import java.util.List;

public class SearchUseCase implements SingleUseCase<SearchUseCase.Query, List<Hero>> {

    public final static class Query {

        final int pageNumber;

        public Query(int pageNumber) {

            this.pageNumber = pageNumber;
        }

    }

    private final HeroRepository mHeroRepository;

    public SearchUseCase(HeroRepository mHeroRepository) {
        this.mHeroRepository = mHeroRepository;
    }

    @Override
    public Single<List<Hero>> execute(Query query) {
        return mHeroRepository.getHeroes(query.pageNumber);
    }

}
