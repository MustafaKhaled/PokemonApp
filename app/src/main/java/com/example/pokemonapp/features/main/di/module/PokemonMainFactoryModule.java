package com.example.pokemonapp.features.main.di.module;

import androidx.lifecycle.ViewModel;

import com.example.pokemonapp.di.mulitbinding.ViewModelKey;
import com.example.pokemonapp.features.main.data.remote.PokemonMainApiService;
import com.example.pokemonapp.features.main.di.scope.MainPokemonScope;
import com.example.pokemonapp.features.main.viewmodel.PokemonMinViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(includes = PokemonMainApiServiceModule.class)
public abstract class PokemonMainFactoryModule {
    @MainPokemonScope
    @Binds
    @IntoMap
    @ViewModelKey(PokemonMinViewModel.class)
    abstract ViewModel shopbysymptomviewmodel(PokemonMinViewModel pokemonMinViewModel);
}
