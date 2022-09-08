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

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SampleViewModel extends ViewModel {
   private LiveData<List<Photo>> liveData;
   private SampleRepo sampleRepo;
    @Inject
    ApiRequest apiRequest;
    @Inject
    public SampleViewModel() {
        sampleRepo=new SampleRepo(apiRequest);
        liveData = sampleRepo.createApi();
    }

    public LiveData<List<Photo>> getLiveData() {
        return liveData;
    }

}
