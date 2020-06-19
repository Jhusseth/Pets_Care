package com.develop.pets_care.view_coll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Coll;
import com.develop.pets_care.view_user.User_Activity_Registration_2;

import java.io.Serializable;
import java.time.LocalDate;


public class Coll_Activity_Registration_1 extends AppCompatActivity implements  View.OnClickListener{

    private Button btnNext;
    private Coll collaborator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Segundo Registro");
        setContentView(R.layout.coll_registration_1);
        btnNext=findViewById(R.id.btn_coll_r1_next);
        btnNext.setOnClickListener(this);

        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        collaborator = (Coll) parameters.getSerializable("coll1");

    }

    private Coll dataColl(){

        EditText date = findViewById(R.id.coll_r1_date);
        EditText address = findViewById(R.id.coll_r1_address);
        EditText phone = findViewById(R.id.coll_r1_phone);


        collaborator.setDate(date.getText().toString());
        collaborator.setAddress(address.getText().toString());
        collaborator.setPhone(phone.getText().toString());

        return collaborator;
    }

    @Override
    public void onClick(View view) {

        if(btnNext==view){
            Intent i = new Intent(this, Coll_Activity_Registration_2.class);
            i.putExtra("coll", (Serializable) dataColl());
            startActivity(i);
        }

    }
}
