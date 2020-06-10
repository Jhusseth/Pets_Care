package com.develop.pets_care.view_user;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.develop.pets_care.R;
import com.google.firebase.auth.FirebaseAuth;

public class User_Activity_Login extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private Button btn_register;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View v) {

        if(btn_login==v){
            Intent i = new Intent(this, User_Activity_Feed.class);
            startActivity(i);
        }
        else if(btn_register==v){
            Intent i = new Intent(this, User_Activity_Registration.class);
            startActivity(i);
        }

    }
}
