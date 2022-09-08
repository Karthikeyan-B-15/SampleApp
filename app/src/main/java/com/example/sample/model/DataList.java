package com.example.sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataList {
    @SerializedName("items")
    @Expose
    private List<Data> items;

    public DataList(List<Data> items) {
        this.items = items;
    }

    public List<Data> getItems() {
        return items;
    }

    public void setItems(List<Data> items) {
        this.items = items;
    }
}
