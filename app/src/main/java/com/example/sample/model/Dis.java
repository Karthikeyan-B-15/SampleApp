package com.example.sample.model;

public class Dis {
    private Owner owner;
    private Title title;
    private Description description;
    private String views;

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Dis(Title title) {
        this.title = title;
    }

    public Dis(Owner owner) {
        this.owner = owner;
    }
}
