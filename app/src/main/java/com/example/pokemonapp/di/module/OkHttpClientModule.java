package com.example.pokemonapp.di.module;

import android.content.Context;

import com.example.pokemonapp.di.scope.ApplicationContextScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = {ContextModule.class})
public class OkHttpClientModule {
    @ApplicationContextScope
    @Provides
    public OkHttpClient getOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    @ApplicationContextScope
    @Provides
    Cache providesCache(File cacheFile){
        return new Cache(cacheFile,10*1000*1000);
    }

    @ApplicationContextScope
    @Provides
    File providesFile(Context context){
        File file = new File(context.getCacheDir(),"HttpCache");
        file.mkdir();
        return file;
    }

    @ApplicationContextScope
    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
