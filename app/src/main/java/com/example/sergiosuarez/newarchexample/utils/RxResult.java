package com.example.sergiosuarez.newarchexample.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class RxResult<T> {

    /**
     * UI STATES
     */
    public enum Status {
        SUCCESS, ERROR, LOADING
    }

    @NonNull
    public final RxResult.Status status;
    @Nullable
    public final Throwable requestError;
    @Nullable
    public final T data;

    private RxResult(@NonNull RxResult.Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.requestError = error;
    }

    public static <T> RxResult<T> success(@Nullable T data) {
        return new RxResult<>(Status.SUCCESS, data, null);
    }

    public static <T> RxResult<T> error(Throwable error) {
        return new RxResult<>(Status.ERROR, null, error);
    }

    public static <T> RxResult<T> loading() {
        return new RxResult<>(Status.LOADING, null, null);
    }

}
