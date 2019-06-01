package com.example.pokemonapp.features.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pokemonapp.R;
import com.example.pokemonapp.databinding.FragmentPokemonMainBinding;
import com.example.pokemonapp.di.mulitbinding.DaggerViewModelFactory;
import com.example.pokemonapp.features.details.ui.PokemonDetailsActivity;
import com.example.pokemonapp.features.main.data.model.PokemonMainResponse;
import com.example.pokemonapp.features.main.di.component.DaggerPokemonMainComponent;
import com.example.pokemonapp.features.main.di.component.PokemonMainComponent;
import com.example.pokemonapp.features.main.viewmodel.PokemonMinViewModel;
import com.example.pokemonapp.util.MyApplication;
import com.example.pokemonapp.util.ResponseApi;

import javax.inject.Inject;

public class PokemonMainFragment extends AppCompatActivity {
    private static final String TAG = "PokemonMainFragment";
    @Inject
    DaggerViewModelFactory daggerViewModelFactory;
    private PokemonMainComponent pokemonMainComponent;
    private PokemonMinViewModel pokemonMinViewModel;
    private FragmentPokemonMainBinding binding;

    public PokemonMainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemonMainComponent = DaggerPokemonMainComponent.builder().appComponent(((MyApplication) getApplication()).getAppComponent()).build();
        pokemonMainComponent.inject(this);
        binding = DataBindingUtil.setContentView(this,R.layout.fragment_pokemon_main);
        pokemonMinViewModel = ViewModelProviders.of(this,daggerViewModelFactory).get(PokemonMinViewModel.class);
        pokemonMinViewModel.getAllPokemons().observe(this,observer);
    }



    @Override
    public void onResume() {
        super.onResume();
    }


    Observer<ResponseApi<PokemonMainResponse>> observer = pokemonMainResponseResponseApi -> {
        switch (pokemonMainResponseResponseApi.status){
            case LOADING:
                binding.progressBar.setVisibility(View.VISIBLE);
                break;

            case SUCCESS:
                TableLayout tableContainer = new TableLayout(this);
                TableLayout.LayoutParams tab_lp = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
                tableContainer.setLayoutParams(tab_lp);
                LayoutInflater inflater = LayoutInflater.from(this);
                binding.progressBar.setVisibility(View.GONE);
                Log.d(TAG, "Result Success");
                if (pokemonMainResponseResponseApi.data != null) {
                    Log.d(TAG, "Response count : "+ pokemonMainResponseResponseApi.data.getResults().size());
                }
                for (int i=0 ; i<pokemonMainResponseResponseApi.data.getResults().size() ; i++){
                    View view = inflater.inflate(R.layout.table_row,null);
                    TextView textView = view.findViewById(R.id.text);
                    textView.setText(pokemonMainResponseResponseApi.data.getResults().get(i).getName());
                    int finalI1 = i;
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =  new Intent(PokemonMainFragment.this, PokemonDetailsActivity.class);
                            intent.putExtra("url",pokemonMainResponseResponseApi.data.getResults().get(finalI1).getUrl());
                            startActivity(intent);
                        }
                    });
                    tableContainer.addView(view);

                }

                binding.parentLayout.addView(tableContainer);
                break;

            case ERROR:
                binding.progressBar.setVisibility(View.GONE);

                break;
        }
    };
}
