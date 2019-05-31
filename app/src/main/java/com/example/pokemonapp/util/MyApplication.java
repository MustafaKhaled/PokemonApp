package com.example.pokemonapp.util;

import android.app.Application;

import com.example.pokemonapp.di.component.AppComponent;
import com.example.pokemonapp.di.component.DaggerAppComponent;
import com.example.pokemonapp.di.module.ContextModule;
import com.example.pokemonapp.di.module.OkHttpClientModule;
import com.example.pokemonapp.di.module.RetrofitModule;

public class MyApplication extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().contextModule(new ContextModule(getApplicationContext()))
                .okHttpClientModule(new OkHttpClientModule()).retrofitModule(new RetrofitModule()).build();
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }

}
