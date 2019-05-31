package com.example.pokemonapp.features.main.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokemonapp.features.main.data.model.PokemonMainResponse;
import com.example.pokemonapp.features.main.data.repo.PokemonMainRepository;
import com.example.pokemonapp.util.ResponseApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PokemonMinViewModel extends ViewModel {
    private PokemonMainRepository pokemonMainRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<ResponseApi<PokemonMainResponse>> observeMainPokemon = new MutableLiveData<>();

    @Inject
    public PokemonMinViewModel(PokemonMainRepository pokemonMainRepository) {
        this.pokemonMainRepository = pokemonMainRepository;
    }

    public MutableLiveData<ResponseApi<PokemonMainResponse>> getAllPokemons() {
       disposable.add(pokemonMainRepository.getAllPokemon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(loading -> observeMainPokemon.postValue(ResponseApi.loading()))
                .subscribe(result -> observeMainPokemon.setValue(ResponseApi.success(result)),
                        throwable -> observeMainPokemon.setValue(ResponseApi.error(throwable))
                        )
        );
        return observeMainPokemon;
    }
}
