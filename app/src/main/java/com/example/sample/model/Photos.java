package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Photos implements Serializable {
    @SerializedName("photo")
   private List<Photo> photo;


    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public Photos(List<Photo> photo) {
        this.photo = photo;
    }
}
