package com.example.pokemonapp.di.module;
import com.example.pokemonapp.di.scope.ApplicationContextScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pokemonapp.util.Constants.BASE_URL;

@Module(includes = OkHttpClientModule.class)
public class RetrofitModule {
    @ApplicationContextScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build();
    }
    @ApplicationContextScope
    @Provides
    public Gson providesGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    @ApplicationContextScope
    @Provides
    public GsonConverterFactory providesGsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
