package com.example.sample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sample.adapter.DisplayAdapter;
import com.example.sample.databinding.ActivityDisplayBinding;
import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.Photo;
import com.example.sample.model.Photos;
import com.example.sample.repository.SampleRepo;
import com.example.sample.viewmodel.SampleViewModel;

import java.util.List;

public class Display extends AppCompatActivity {
    ActivityDisplayBinding binding;
    private DisplayAdapter adapter;
    private RecyclerView recyclerView;
    private List<Photo> photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDisplayBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        getViewModel();
        createRecycle();

    }

    public void getViewModel(){
        SampleViewModel sampleViewModel=new ViewModelProvider(this).get(SampleViewModel.class);
        sampleViewModel.getLiveData().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                Log.d("dis",String.valueOf(photos));
                photo=photos;
            }
        });

    }
    public void createRecycle(){
        recyclerView=binding.srecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DisplayAdapter(photo);
        recyclerView.setAdapter(adapter);
    }
}