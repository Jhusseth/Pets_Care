package com.develop.pets_care.view_user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.develop.pets_care.R;
import com.develop.pets_care.model.Users;

import java.io.Serializable;

public class User_Activity_Registration extends AppCompatActivity implements  View.OnClickListener {

    private Button btnNext;
    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);

        btnNext = findViewById(R.id.btn_r_next);
        btnNext.setOnClickListener(this);

        user = new Users();
    }

    public Users dataUser() {

        EditText idUser = findViewById(R.id.user_r_id);
        EditText name = findViewById(R.id.coll_r_name);
        EditText email = findViewById(R.id.coll_r_email);
        EditText password = findViewById(R.id.coll_r_password);


        user.setId(idUser.getText().toString());
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());

        return user;
    }

    @Override
    public void onClick(View v) {

        if(btnNext==v){
            Intent i = new Intent(this, User_Activity_Registration_1.class);
            i.putExtra("user1", (Serializable) dataUser());
            startActivity(i);
        }
    }
}
