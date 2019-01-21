package com.example.domain.favorite;

import com.example.domain.FlowableUseCase;
import com.example.domain.HeroRepository;
import com.example.model.Hero;
import io.reactivex.Flowable;

import java.util.List;

public class GetFavoritesUseCase implements FlowableUseCase<GetFavoritesUseCase.Query, List<Hero>> {

    public final static class Query {

    }

    private final HeroRepository mRepository;

    public GetFavoritesUseCase(HeroRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public Flowable<List<Hero>> execute(Query query) {
        return mRepository.getFavorites();
    }

}
