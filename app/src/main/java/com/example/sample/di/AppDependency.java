package com.example.sample.di;

import com.example.sample.network.ApiRequest;
import com.example.sample.repository.SampleRepo;
import com.example.sample.viewmodel.SampleViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppDependency {
    String baseurl="https://www.flickr.com/services/rest/";
    public static final String API_KEY="6875a6037041f0fe5c4e5781f5c08b7e";
    @Singleton
    @Provides
    public  ApiRequest getRetroApiRequest(Retrofit retrofit){
        return retrofit.create(ApiRequest.class);
    }


    @Singleton
    @Provides
    public  Retrofit getInstance(){

        return new Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
