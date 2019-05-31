package com.example.pokemonapp.features.details.data.remote;

import com.example.pokemonapp.features.details.data.model.PokemonDetailsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PokemonDetailsApiService {

    @GET
    Single<PokemonDetailsResponse> getDetails();

}
