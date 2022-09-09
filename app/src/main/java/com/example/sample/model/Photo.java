package com.example.sample.model;

import android.icu.text.CaseMap;
import android.util.EventLogTags;
import android.widget.ArrayAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//public class Photo {
//    private String id;
//    private String secret;
//    private String server;
//    private String farm;
//
//
////    private Owner owner;
////    private Title title;
////    private Description description;
//    private String views;
//
//    public Owner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
//
//    public Title getTitle() {
//        return title;
//    }

//    public void setTitle(Title title) {
//        this.title = title;
//    }
//
//    public Description getDescription() {
//        return description;
//    }
//
//    public void setDescription(Description description) {
//        this.description = description;
//    }


public class Photo {

@SerializedName("id")
@Expose
private String id;
@SerializedName("secret")
@Expose
private String secret;
@SerializedName("server")
@Expose
private String server;
@SerializedName("farm")
@Expose
private Integer farm;
private String views;

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @SerializedName("owner")
@Expose
private Owner owner;
@SerializedName("title")
@Expose
private Title title;
@SerializedName("stat")
@Expose
private String stat;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getSecret() {
return secret;
}

public void setSecret(String secret) {
this.secret = secret;
}

public String getServer() {
return server;
}

public void setServer(String server) {
this.server = server;
}

public Integer getFarm() {
return farm;
}

public void setFarm(Integer farm) {
this.farm = farm;
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

public String getStat() {
return stat;
}

public void setStat(String stat) {
this.stat = stat;
}

}
