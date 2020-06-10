package com.develop.pets_care.view_user;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.develop.pets_care.R;
import com.develop.pets_care.model.Users;

import java.time.LocalDate;

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


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Users dataUser() {

        EditText name = findViewById(R.id.user_r_name);
        EditText email = findViewById(R.id.user_r_email);
        EditText password = findViewById(R.id.user_r_password);
        EditText date = findViewById(R.id.user_r_date);
        EditText address = findViewById(R.id.user_r_address);
        EditText phone = findViewById(R.id.user_r_phone);


        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        user.setDate(LocalDate.parse(date.getText().toString()));
        user.setAddress(address.getText().toString());
        user.setPhone(phone.getText().toString());

        return user;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {

        if(btnNext==v){
            Intent i = new Intent(this, User_Activity_Registration_2.class);
            i.putExtra("user", (Parcelable) dataUser());
            startActivity(i);
        }
    }
}
