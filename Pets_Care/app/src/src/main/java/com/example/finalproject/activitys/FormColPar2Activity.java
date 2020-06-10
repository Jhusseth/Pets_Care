package com.example.finalproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.finalproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FormColPar2Activity extends AppCompatActivity {


    Button buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formcolpart2);
        buttonFinish=findViewById(R.id.finishedRegCol);

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(FormColPar2Activity.this,MenuColActivity.class);
                startActivity(intent);
            }
        });
    }


}
