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


public class Coll_Activity_Registration extends AppCompatActivity implements  View.OnClickListener{

    private Button btnNext;
    private Coll collaborator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Primer Registro");
        setContentView(R.layout.coll_registration);
        btnNext=findViewById(R.id.btn_coll_r_next);
        btnNext.setOnClickListener(this);

        collaborator = new Coll();
    }

    private Coll dataColl(){

        EditText idColl =  findViewById(R.id.coll_r_id);
        EditText name = findViewById(R.id.coll_r_name);
        EditText email = findViewById(R.id.coll_r_email);
        EditText password = findViewById(R.id.coll_r_password);

        collaborator.setId(idColl.getText().toString());
        collaborator.setName(name.getText().toString());
        collaborator.setEmail(email.getText().toString());
        collaborator.setPassword(password.getText().toString());

        return collaborator;
    }

    @Override
    public void onClick(View view) {

        if(btnNext==view){
            Intent i = new Intent(this, Coll_Activity_Registration_1.class);
            i.putExtra("coll1", (Serializable) dataColl());
            startActivity(i);
        }

    }
}
