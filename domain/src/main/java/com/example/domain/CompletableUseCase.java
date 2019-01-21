package com.example.domain;

import io.reactivex.Completable;

public interface CompletableUseCase<Q> {

    Completable execute(Q query);
}
