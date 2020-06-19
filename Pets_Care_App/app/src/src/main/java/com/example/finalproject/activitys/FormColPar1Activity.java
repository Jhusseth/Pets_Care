package com.example.finalproject.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.finalproject.R;


public class FormColPar1Activity extends AppCompatActivity {

    private Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formcolpart1);
        buttonNext=findViewById(R.id.nextFragment);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormColPar1Activity.this,FormColPar2Activity.class);
                startActivity(intent);
            }
        });

    }

}
