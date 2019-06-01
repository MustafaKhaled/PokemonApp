package com.example.pokemonapp.features.details.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pokemonapp.R;
import com.example.pokemonapp.databinding.FragmentPokemonDetailsBinding;
import com.example.pokemonapp.di.mulitbinding.DaggerViewModelFactory;
import com.example.pokemonapp.features.details.data.model.PokemonDetailsResponse;
import com.example.pokemonapp.features.details.di.component.DaggerPokemonDetailsComponent;
import com.example.pokemonapp.features.details.di.component.PokemonDetailsComponent;
import com.example.pokemonapp.features.details.viewmodel.PokemonDetailsViewModel;
import com.example.pokemonapp.util.MyApplication;
import com.example.pokemonapp.util.ResponseApi;

import javax.inject.Inject;

public class PokemonDetailsActivity extends AppCompatActivity {
    private static final String TAG = "PokemonDetailsActivity";
    @Inject
    DaggerViewModelFactory daggerViewModelFactory;
    private PokemonDetailsViewModel pokemonDetailsViewModel;
    FragmentPokemonDetailsBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.fragment_pokemon_details);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value1 = extras.getString("url");
        if (value1 != null) {
            Log.d(TAG, "onCreate: Url is " +value1);
            // do something with the data
        }
        PokemonDetailsComponent pokemonDetailsComponent = DaggerPokemonDetailsComponent.builder().appComponent(((MyApplication) getApplication()).getAppComponent()).build();
        pokemonDetailsComponent.inject(this);
        pokemonDetailsViewModel = ViewModelProviders.of(this,daggerViewModelFactory).get(PokemonDetailsViewModel.class);
        pokemonDetailsViewModel.getAllDetails(value1).observe(this,observer);
    }

    Observer<ResponseApi<PokemonDetailsResponse>> observer = pokemonDetailsResponseResponseApi -> {
        switch (pokemonDetailsResponseResponseApi.status){
            case LOADING:
                Log.d(TAG, "Observer: Loading ...");
                binding.progressBar.setVisibility(View.VISIBLE);
                break;


            case SUCCESS:
                Log.d(TAG, "Observer: Success");
                Log.d(TAG, "Observer data: "+ pokemonDetailsResponseResponseApi.data.getAbilities().size());
                binding.progressBar.setVisibility(View.GONE);
                binding.setPokemon(pokemonDetailsResponseResponseApi.data);
                break;


            case ERROR:
                Log.d(TAG, "Observer: Error");
                binding.progressBar.setVisibility(View.GONE);

                break;
        }
    };


    @Override
    public void onResume() {
        super.onResume();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

