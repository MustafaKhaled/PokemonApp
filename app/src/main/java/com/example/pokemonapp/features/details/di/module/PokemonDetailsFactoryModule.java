package com.example.pokemonapp.features.details.di.module;

import androidx.lifecycle.ViewModel;

import com.example.pokemonapp.di.mulitbinding.ViewModelKey;
import com.example.pokemonapp.features.details.data.remote.PokemonDetailsApiService;
import com.example.pokemonapp.features.details.di.scope.PokemonDetailsScope;
import com.example.pokemonapp.features.details.viewmodel.PokemonDetailsViewModel;
import com.example.pokemonapp.features.main.di.module.PokemonMainApiServiceModule;
import com.example.pokemonapp.features.main.di.scope.MainPokemonScope;
import com.example.pokemonapp.features.main.viewmodel.PokemonMinViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
@Module(includes = PokemonDetailsApiServiceModule.class)
public abstract class PokemonDetailsFactoryModule {
    @PokemonDetailsScope
    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel.class)
    abstract ViewModel pokemonDetailsViewModel(PokemonDetailsViewModel pokemonDetailsViewModel);
}
