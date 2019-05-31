package com.example.pokemonapp.features.details.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemonapp.R;

public class PokemonDetailsFragment extends AppCompatActivity {
    private static final String TAG = "PokemonDetailsFragment";
    public PokemonDetailsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value1 = extras.getString("url");
        if (value1 != null) {
            Log.d(TAG, "onCreate: Url is " +value1);
            // do something with the data
        }
    }


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

