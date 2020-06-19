package com.develop.pets_care.view_user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Users;

import java.io.Serializable;
import java.time.LocalDate;

public class User_Activity_Registration_1 extends AppCompatActivity implements  View.OnClickListener {

    private Button btnNext;
    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration_1);

        btnNext = findViewById(R.id.btn_coll_r1_next);
        btnNext.setOnClickListener(this);

        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        user = (Users) parameters.getSerializable("user1");
    }

    public Users dataUser() {
        EditText date = findViewById(R.id.coll_r1_date);
        EditText address = findViewById(R.id.coll_r1_address);
        EditText phone = findViewById(R.id.coll_r1_phone);
        user.setDate(date.getText().toString());
        user.setAddress(address.getText().toString());
        user.setPhone(phone.getText().toString());

        return user;
    }

    @Override
    public void onClick(View v) {

        if(btnNext==v){
            Intent i = new Intent(this, User_Activity_Registration_2.class);
            i.putExtra("user", (Serializable) dataUser());
            startActivity(i);
        }
    }
}
