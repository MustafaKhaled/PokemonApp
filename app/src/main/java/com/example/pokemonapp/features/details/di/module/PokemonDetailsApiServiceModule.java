package com.example.pokemonapp.features.details.di.module;

import com.example.pokemonapp.features.details.data.remote.PokemonDetailsApiService;
import com.example.pokemonapp.features.main.data.remote.PokemonMainApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PokemonDetailsApiServiceModule {
    @Provides
    PokemonDetailsApiService providesPokemonMainApiService(Retrofit retrofit){
        return retrofit.create(PokemonDetailsApiService.class);
    }
}
