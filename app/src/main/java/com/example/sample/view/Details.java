package com.example.sample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sample.R;
import com.example.sample.adapter.DisplayAdapter;
import com.example.sample.model.Photo;
import com.example.sample.viewmodel.SampleViewModel;

import java.util.List;

import javax.inject.Inject;

public class Details extends AppCompatActivity {
    Intent intent;
    ImageView imageView;
    DisplayAdapter adapter;
    List<Photo> list;
    Photo photo;
    TextView user,location,views,title,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        intent=getIntent();

        imageView=(ImageView) findViewById(R.id.detailsimg);
        user=(TextView)findViewById(R.id.user);
        views=(TextView)findViewById(R.id.views);
        location=(TextView)findViewById(R.id.location);
        title=(TextView)findViewById(R.id.title1);
        desc=(TextView)findViewById(R.id.desc);
        Glide.with(imageView.getContext())
                .load(intent.getStringExtra("image"))
                .into(imageView);
        getDetailViewModwel(intent.getIntExtra("position",0));
    }
    public void getDetailViewModwel(int pos){
        SampleViewModel sampleViewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        sampleViewModel.setDetail(intent.getStringExtra("id"),intent.getStringExtra("secret"),pos);
        sampleViewModel.getUserLivData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                user.setText(s);
            }
        });
        sampleViewModel.getViewsLivData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                views.setText(s);
            }
        });
        sampleViewModel.getTitleLivData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                title.setText(s);
            }
        });
        sampleViewModel.getLocationLivData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                location.setText(s);
            }
        });
        sampleViewModel.getDescLivData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                desc.setText(s);
            }
        });
    }
}