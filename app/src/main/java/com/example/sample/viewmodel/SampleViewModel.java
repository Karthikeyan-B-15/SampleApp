package com.example.sample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.Photo;
import com.example.sample.model.Photos;
import com.example.sample.network.ApiRequest;
import com.example.sample.repository.SampleRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SampleViewModel extends ViewModel {
   private MutableLiveData<List<Photo>> liveData;
   private MutableLiveData<String> user,location,title,desc,views;
   private SampleRepo sampleRepo;
    String query ;

    public void setQuery(String query) {
        this.query = query;
    }

    @Inject
    ApiRequest apiRequest;
    @Inject
    public SampleViewModel() {
        liveData = new MutableLiveData<>();
        user=new MutableLiveData<>();
        location=new MutableLiveData<>();
        title=new MutableLiveData<>();
        desc=new MutableLiveData<>();
        views=new MutableLiveData<>();
    }
    public void insert(String query){
        SampleRepo sampleRepo=new SampleRepo(apiRequest);
        sampleRepo.createApi(query,liveData);

    }
public void setDetail(String id,String secret,int pos){
        SampleRepo sampleRepo=new SampleRepo(apiRequest);
        sampleRepo.createDetailApi(id,secret,pos,user,location,title,desc,views);
}



    public LiveData<List<Photo>> getLiveData() {
        return liveData;
    }
//    public LiveData<String> getUserLivData(){return user;}
//    public LiveData<String> getLocationLivData(){return location;}
    public LiveData<String> getViewsLivData(){return views;}
//    public LiveData<String> getDescLivData(){return desc;}
//    public LiveData<String> getTitleLivData(){return title;}

}
