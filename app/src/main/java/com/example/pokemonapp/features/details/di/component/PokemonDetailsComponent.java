package com.example.pokemonapp.features.details.di.component;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pokemonapp.features.details.di.module.PokemonDetailsApiServiceModule;
import com.example.pokemonapp.features.details.di.module.PokemonDetailsFactoryModule;
import com.example.pokemonapp.features.details.ui.PokemonDetailsFragment;
import com.example.pokemonapp.features.main.di.module.PokemonMainApiServiceModule;

import dagger.Component;

@Component(dependencies = AppCompatActivity.class,modules = {PokemonDetailsApiServiceModule.class, PokemonDetailsFactoryModule.class})
public interface PokemonDetailsComponent {
    void inject(PokemonDetailsFragment pokemonDetailsFragment);
}
