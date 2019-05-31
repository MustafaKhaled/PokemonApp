package com.example.pokemonapp.features.main.data.repo;

import com.example.pokemonapp.features.main.data.model.PokemonMainResponse;
import com.example.pokemonapp.features.main.data.remote.PokemonMainApiService;

import javax.inject.Inject;

import io.reactivex.Single;

public class PokemonMainRepository {

    private PokemonMainApiService pokemonMainApiService;
    @Inject
    public PokemonMainRepository(PokemonMainApiService pokemonMainApiService) {
        this.pokemonMainApiService = pokemonMainApiService;
    }

    public Single<PokemonMainResponse> getAllPokemon(){
        return pokemonMainApiService.getPokemonMainResponse();
    }
}
