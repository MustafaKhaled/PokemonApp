package com.example.pokemonapp.di.component;

import android.content.Context;

import com.example.pokemonapp.di.module.ContextModule;
import com.example.pokemonapp.di.module.RetrofitModule;
import com.example.pokemonapp.di.scope.ApplicationContextScope;

import dagger.Component;
import retrofit2.Retrofit;
@ApplicationContextScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface AppComponent {
    Context exposeContext();
    Retrofit exposeRetrofit();
}
