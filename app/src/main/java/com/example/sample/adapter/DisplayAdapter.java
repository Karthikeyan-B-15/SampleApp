package com.example.sample.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sample.databinding.ListitemBinding;
import com.example.sample.model.Data;
import com.example.sample.model.DataList;
import com.example.sample.model.Photo;
import com.example.sample.model.Photos;

import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {
    private List<Photo> items;

//    public void setItems(List<Photo> items){
//        Log.d("check", String.valueOf(items.get(0)));
//
//        this.items=items;
//    }
    public DisplayAdapter(List<Photo> items){
        this.items=items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo=items.get(position);
//        Glide.with(holder.binding.image.getContext())
//                .load("https://farm"+photo.getFarm()
//                        +".staticflickr.com/"+photo.getServer()+"/"
//
        Glide.with(holder.binding.imageart.getContext())
                .load("https://farm66.staticflickr.com/65535/52340117596_d10471159d.jpg")
                .into(holder.binding.imageart);
    }

    @Override
    public int getItemCount() {
        if(items==null){
            return 0;
        }
        else {
            Log.d("len",String.valueOf(items.size()));
            return items.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListitemBinding binding;
        public ViewHolder(@NonNull  ListitemBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }
}
