package com.example.sample.model;

import java.util.List;

public class Photos {
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
