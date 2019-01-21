package com.example.domain;

import io.reactivex.Single;

public interface SingleUseCase<Q, R> {

    Single<R> execute(Q query);

}
