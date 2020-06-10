package com.develop.pets_care.view_coll;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;

public class Coll_Activity_Registration_2 extends AppCompatActivity {


    Button buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_registration_2);
        buttonFinish=findViewById(R.id.finishedRegCol);

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent= new Intent(Coll_Activity_Registration_2.this,MenuColActivity.class);
                startActivity(intent);*/
            }
        });
    }


}
