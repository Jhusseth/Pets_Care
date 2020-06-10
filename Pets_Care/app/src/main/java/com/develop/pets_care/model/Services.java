package com.develop.pets_care.model;

import android.graphics.Bitmap;

public class Services {

    private String title;
    private String description;
    private Bitmap Image;
    private Bitmap perfil;
    private String state;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Bitmap getImage() {
        return Image;
    }

    public Bitmap getPerfil() {
        return perfil;
    }

    public String getState() {
        return state;
    }

    public Services(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Bitmap image) {
        Image = image;
    }

    public void setPerfil(Bitmap perfil) {
        this.perfil = perfil;
    }
}
