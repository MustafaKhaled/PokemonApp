package com.example.pokemonapp.features.details.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokemonapp.features.details.data.model.PokemonDetailsResponse;
import com.example.pokemonapp.features.details.data.repo.PokemonDetailsReposiotry;
import com.example.pokemonapp.features.main.data.model.PokemonMainResponse;
import com.example.pokemonapp.util.ResponseApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PokemonDetailsViewModel extends ViewModel {
    private PokemonDetailsReposiotry pokemonDetailsReposiotry;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<ResponseApi<PokemonDetailsResponse>> observewDetails = new MutableLiveData<>();

    @Inject
    public PokemonDetailsViewModel(PokemonDetailsReposiotry pokemonDetailsReposiotry) {
        this.pokemonDetailsReposiotry = pokemonDetailsReposiotry;
    }

    public MutableLiveData<ResponseApi<PokemonDetailsResponse>> getAllDetails(String url){
        disposable.add(pokemonDetailsReposiotry.getAllDetails(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(loading -> observewDetails.postValue(ResponseApi.loading()))
                .subscribe(result -> observewDetails.setValue(ResponseApi.success(result)),
                        throwable -> observewDetails.setValue(ResponseApi.error(throwable))
                )
        );
        return observewDetails;
    }
}
