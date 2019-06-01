package com.example.pokemonapp.features.details.data.repo;

import com.example.pokemonapp.features.details.data.model.PokemonDetailsResponse;
import com.example.pokemonapp.features.details.data.remote.PokemonDetailsApiService;

import javax.inject.Inject;

import io.reactivex.Single;

public class PokemonDetailsReposiotry {
    private PokemonDetailsApiService pokemonDetailsApiService;
    @Inject
    public PokemonDetailsReposiotry(PokemonDetailsApiService pokemonDetailsApiService) {
        this.pokemonDetailsApiService = pokemonDetailsApiService;
    }

    public Single<PokemonDetailsResponse> getAllDetails(String url){
        return pokemonDetailsApiService.getDetails(url);
    }
}
