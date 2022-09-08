package com.example.sample.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sample.di.AppDependency;
import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.Photo;
import com.example.sample.model.Photos;
import com.example.sample.network.ApiRequest;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.InstallIn;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampleRepo {
    private ApiRequest apiRequest;
    @Inject
    public SampleRepo(ApiRequest apiRequest) {

        this.apiRequest =new AppDependency().getInstance().create(ApiRequest.class);

    }
    public LiveData<List<Photo>> createApi(){
       final MutableLiveData<List<Photo>> data=new MutableLiveData<>();
        apiRequest.getRequest().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                Log.d("msg",String.valueOf(response.body().getPhotos().getPhoto()));
                if(response.body()!=null){
                    data.postValue(response.body().getPhotos().getPhoto());
                }
                else{
                    data.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;

    }
}
