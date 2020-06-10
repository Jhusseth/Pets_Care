package com.develop.pets_care.model;

import android.graphics.Bitmap;

import com.google.firebase.database.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public class Users implements Serializable {

    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private LocalDate date;
    private String address;
    private String phone;
    private Bitmap avatar;
    private String description;


    public Users(String id,String name, String email, String password, LocalDate date, String address, String phone,Bitmap avatar, String description){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.description = description;
    }

    public Users() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public String getDescription() {
        return description;
    }
}
