package com.example.pokemonapp.features.details.di.component;

import com.example.pokemonapp.di.component.AppComponent;
import com.example.pokemonapp.features.details.di.module.PokemonDetailsApiServiceModule;
import com.example.pokemonapp.features.details.di.module.PokemonDetailsFactoryModule;
import com.example.pokemonapp.features.details.di.scope.PokemonDetailsScope;
import com.example.pokemonapp.features.details.ui.PokemonDetailsActivity;

import dagger.Component;
@PokemonDetailsScope
@Component(dependencies = {AppComponent.class} , modules = {PokemonDetailsFactoryModule.class , PokemonDetailsApiServiceModule.class})
public interface PokemonDetailsComponent {
    void inject(PokemonDetailsActivity pokemonDetailsActivity);
}
