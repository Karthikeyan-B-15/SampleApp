package com.example.sample.model;

public class DetailModel {
    private Photo photo;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public DetailModel(Photo photo) {
        this.photo = photo;
    }
}
