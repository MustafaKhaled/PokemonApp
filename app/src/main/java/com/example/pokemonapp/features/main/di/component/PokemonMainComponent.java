package com.example.pokemonapp.features.main.di.component;

import com.example.pokemonapp.di.component.AppComponent;
import com.example.pokemonapp.di.mulitbinding.ViewModelFactoryModule;
import com.example.pokemonapp.features.main.di.module.PokemonMainFactoryModule;
import com.example.pokemonapp.features.main.di.scope.MainPokemonScope;
import com.example.pokemonapp.features.main.ui.PokemonMainFragment;

import dagger.Component;
@MainPokemonScope
@Component(dependencies = AppComponent.class,modules = {ViewModelFactoryModule.class, PokemonMainFactoryModule.class})
public interface PokemonMainComponent {
    void inject(PokemonMainFragment pokemonMainFragment);
}
