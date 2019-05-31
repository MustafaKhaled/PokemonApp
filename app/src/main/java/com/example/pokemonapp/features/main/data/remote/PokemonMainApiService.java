package com.example.pokemonapp.features.main.data.remote;

import com.example.pokemonapp.features.main.data.model.PokemonMainResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PokemonMainApiService {

    @GET("pokemon/")
    Single<PokemonMainResponse> getPokemonMainResponse();
}
