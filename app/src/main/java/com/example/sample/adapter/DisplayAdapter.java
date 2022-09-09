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
    private RecyclerViewClickListener listener;

    public void setItems(List<Photo> items){
        Log.d("check", String.valueOf(items.get(0)));

        this.items=items;
        notifyDataSetChanged();
    }
    public DisplayAdapter (RecyclerViewClickListener listener){
        this.listener=listener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }


    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo=items.get(position);
        Glide.with(holder.binding.imageart.getContext()).load(getUrl(photo)).into(holder.binding.imageart);

    }
    public String getUrl(Photo photo){
        return "https://farm"+photo.getFarm() +".staticflickr.com/"+photo.getServer()+"/"+photo.getId()+"_"+photo.getSecret()+".jpg";
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
public interface RecyclerViewClickListener{
        void onClick(View v,int position);
}
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ListitemBinding binding;
        public ViewHolder(@NonNull  ListitemBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
            itemView.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }

    }
}
