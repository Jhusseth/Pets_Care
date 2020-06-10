package com.develop.pets_care.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.develop.pets_care.R;
import com.develop.pets_care.view_user.User_Activity_Login;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener {

    private Button btnUser;
    private Button btnCollaborator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnUser = findViewById(R.id.btn_user);
        btnCollaborator = findViewById(R.id.btn_collaborator);

        btnUser.setOnClickListener(this);
        btnCollaborator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(btnUser==v){
            Intent i = new Intent(this, User_Activity_Login.class);
            startActivity(i);
        }
        else if(btnCollaborator==v){

        }
    }
}
