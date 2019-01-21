package com.example.sergiosuarez.newarchexample.utils;

import io.reactivex.ObservableTransformer;

public class RxUtils {

    public static <T> ObservableTransformer<T, RxResult<T>> transformToRxResult() {
        return upstream -> upstream
                .map(RxResult::success)
                .onErrorReturn(RxResult::error);
    }
}
