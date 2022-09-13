package com.example.sample.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.sample.R;
import com.example.sample.adapter.DisplayAdapter;
import com.example.sample.databinding.ActivityDisplayBinding;
import com.example.sample.model.Photo;
import com.example.sample.viewmodel.SampleViewModel;

import java.util.List;

public class Display extends AppCompatActivity {
    private ActivityDisplayBinding binding;
    private DisplayAdapter adapter;
    private RecyclerView recyclerView;
    private List<Photo> list;
    private DisplayAdapter.RecyclerViewClickListener listener;
    private boolean change=false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intent = getIntent();

        createRecycle();
        getViewModel(intent.getStringExtra("keyword"));

    }

    public void createRecycle() {
        setOnClick();
        recyclerView = binding.srecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DisplayAdapter(listener);
        recyclerView.setAdapter(adapter);
    }
public void setOnClick(){
        listener=new DisplayAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Photo photo=list.get(position);
                Intent intent=new Intent(getApplicationContext(),Details.class);
                intent.putExtra("image",adapter.getUrl(photo));
                intent.putExtra("id",photo.getId());
                intent.putExtra("secret",photo.getSecret());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };
}
    public void getViewModel(String val) {

        SampleViewModel sampleViewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        Log.d("keyword", val);
        sampleViewModel.insert(val);
        sampleViewModel.getLiveData().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                Log.d("dis", String.valueOf(photos));
                adapter.setItems(photos);
                list=photos;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.view,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.view:
                if(!change) {
                    recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
                    item.setIcon(R.drawable.ic_list);
                    change=true;
                }else{
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    item.setIcon(R.drawable.ic_baseline_grid_view_24);
                    change=false;
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}