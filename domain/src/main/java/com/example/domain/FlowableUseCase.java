package com.example.domain;

import io.reactivex.Flowable;

public interface FlowableUseCase<Q, R> {

    Flowable<R> execute(Q query);
}
