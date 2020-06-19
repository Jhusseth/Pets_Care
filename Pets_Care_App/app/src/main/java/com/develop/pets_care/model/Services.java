package com.develop.pets_care.model;

import androidx.annotation.IdRes;
import com.google.auto.value.AutoValue;
import com.google.firebase.auth.ActionCodeResult;

import java.io.Serializable;

public class Services implements Serializable {

    private String title;
    private String description;
    private String Image;
    private String state;
    private String idColl;
    private String id;

    public void setState(String state) {
        this.state = state;
    }

    public void setIdColl(String idColl) {
        this.idColl = idColl;
    }

    public String getIdColl() {
        return idColl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return Image;
    }


    public String getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Services(){
        int i = (int) (Math.random()*10)+1;
        id = "S" + i;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        Image = image;
    }

}
