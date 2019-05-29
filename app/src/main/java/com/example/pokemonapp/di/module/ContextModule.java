package com.example.pokemonapp.di.module;

import android.content.Context;
import com.example.pokemonapp.di.scope.ApplicationContextScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }
    @ApplicationContextScope
    @Provides
    Context providesContext(){
        return context;
    }
}
