package com.example.sample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sample.R;
import com.example.sample.databinding.ActivityMainBinding;
import com.example.sample.di.AppDependency;
import com.example.sample.viewmodel.SampleViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        keyword = binding.key.getText().toString();


        binding.get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("query1", binding.key.getText().toString());
                Intent intent = new Intent(MainActivity.this, Display.class);
                intent.putExtra("keyword",keyword);
                startActivity(intent);
            }
        });

    }

}