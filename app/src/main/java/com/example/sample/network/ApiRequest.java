package com.example.sample.network;

import static com.example.sample.di.AppDependency.API_KEY;

import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.DetailModel;
import com.example.sample.model.Owner;
import com.example.sample.model.Photo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("?method=flickr.photos.search&api_key="+API_KEY+"&format=json&nojsoncallback=1&")
    Call<Data> getRequest(@Query("text") String query);
    @GET("?method=flickr.photos.getInfo&api_key="+API_KEY+"&format=json&nojsoncallback=1&")
    Call<DetailModel> getDetailRequest(@Query("photo_id") String id, @Query("secret") String secret);

}
