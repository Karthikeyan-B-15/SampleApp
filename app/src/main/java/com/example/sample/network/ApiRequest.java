package com.example.sample.network;

import com.example.sample.model.Data;
import com.example.sample.model.DataList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=kart&format=json&nojsoncallback=1")
    Call<Data> getRequest();

}
