package com.example.pokemonapp.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.a800pharmacy.app.util.Status.ERROR;
import static com.a800pharmacy.app.util.Status.LOADING;
import static com.a800pharmacy.app.util.Status.SUCCESS;
import static com.example.pokemonapp.util.Status.ERROR;
import static com.example.pokemonapp.util.Status.LOADING;
import static com.example.pokemonapp.util.Status.SUCCESS;

public class ResposeApi<T> {
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    private ResposeApi(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T>ResposeApi<T> loading() {
        return new ResposeApi<>(LOADING, null, null);
    }

    public static <T> ResposeApi success(@NonNull T data) {
        return new ResposeApi<>(SUCCESS, data, null);
    }

    public static <T>ResposeApi<T> error(@NonNull Throwable error) {
        return new ResposeApi<>(ERROR,  null, error);
    }

}
