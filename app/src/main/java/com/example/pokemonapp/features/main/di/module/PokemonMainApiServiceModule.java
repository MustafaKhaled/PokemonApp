package com.example.pokemonapp.features.main.di.module;

import com.example.pokemonapp.features.main.data.remote.PokemonMainApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
@Module
public class PokemonMainApiServiceModule {
    @Provides
    PokemonMainApiService providesPokemonMainApiService(Retrofit retrofit){
        return retrofit.create(PokemonMainApiService.class);
    }
}
