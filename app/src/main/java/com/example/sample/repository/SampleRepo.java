package com.example.sample.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sample.di.AppDependency;
import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.DetailModel;
import com.example.sample.model.Owner;
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

    public void createApi(String query,MutableLiveData<List<Photo>> liveData){
       final MutableLiveData<List<Photo>> data=new MutableLiveData<>();

        apiRequest.getRequest(query).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                if(response.body()!=null){
                    liveData.postValue(response.body().getPhotos().getPhoto());
                }
                else{
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("err",String.valueOf(t));
              data.postValue(null);
            }
        });


    }
//    public void createDetailApi(String id,String secret,int pos,MutableLiveData<String> user,
//                                MutableLiveData<String> location,
//                                MutableLiveData<String> title,
//                                MutableLiveData<String> desc,
//                                MutableLiveData<String> views){
//        apiRequest.getDetailRequest(id,secret).enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(Call<Data> call, Response<Data> response) {
//                if(response.body()!=null){
//                    user.postValue(response.body().getPhotos().getPhoto().get(pos).getOwner().getUsername());
//                    location.postValue(response.body().getPhotos().getPhoto().get(pos).getOwner().getUsername());
//                    title.postValue(response.body().getPhotos().getPhoto().get(pos).getTitle().get_content());
//                    desc.postValue(response.body().getPhotos().getPhoto().get(pos).getDescription().get_content());
//                    views.postValue(response.body().getPhotos().getPhoto().get(pos).getViews());
//
//                }
//                else{
//                    user.postValue(null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Data> call, Throwable t) {
//            user.postValue(null);
//            }
//        });
//
//    }
public void createDetailApi(String id,String secret,int pos,MutableLiveData<String> user,
                                MutableLiveData<String> location,
                                MutableLiveData<String> title,
                                MutableLiveData<String> desc,
                                MutableLiveData<String> views){
        apiRequest.getDetailRequest(id, secret).enqueue(new Callback<DetailModel>() {
            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {
                if(response.body()!=null){
                    Log.d("id",response.body().getPhoto().getId());
//                    user.postValue(response.body().getPhoto().getOwner().getUsername());
//                    location.postValue(response.body().getPhoto().getOwner().getUsername());
//                    title.postValue(response.body().getPhoto().getTitle().get_content());
//                    desc.postValue(response.body().getPhoto().getDescription().get_content());
                    views.postValue(response.body().getPhoto().getViews());

                }
                else{
                    user.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {

            }
        });
}
}

