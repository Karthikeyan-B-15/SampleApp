package com.example.sample.model;

public class Owner {
    private String username;
    private String location;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Owner(String username, String location) {
        this.username = username;
        this.location = location;
    }
}
