package com.example.pokemonapp.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import static com.example.pokemonapp.util.Status.ERROR;
import static com.example.pokemonapp.util.Status.LOADING;
import static com.example.pokemonapp.util.Status.SUCCESS;

public class ResponseApi<T> {
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    private ResponseApi(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ResponseApi<T> loading() {
        return new ResponseApi<>(LOADING, null, null);
    }

    public static <T> ResponseApi success(@NonNull T data) {
        return new ResponseApi<>(SUCCESS, data, null);
    }

    public static <T> ResponseApi<T> error(@NonNull Throwable error) {
        return new ResponseApi<>(ERROR,  null, error);
    }

}
