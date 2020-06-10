package com.develop.pets_care.view_coll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;


public class Coll_Activity_Registration extends AppCompatActivity {

    private Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_registration);
        buttonNext=findViewById(R.id.nextFragment);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Coll_Activity_Registration.this, Coll_Activity_Registration_2.class);
                startActivity(intent);
            }
        });

    }

}
