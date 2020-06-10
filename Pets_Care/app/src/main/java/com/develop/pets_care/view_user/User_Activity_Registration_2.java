package com.develop.pets_care.view_user;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.develop.pets_care.R;
import com.develop.pets_care.model.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_Activity_Registration_2 extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "";
    private Users user;

    private ImageView avatar;
    private ImageButton btnButton;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_resgistration_2);

        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        user = parameters.getParcelable("user");

        TextView name = findViewById(R.id.user_r2_name);
        name.setText(user.getName());

        avatar = findViewById(R.id.user_r2_photo);
        btnButton = findViewById(R.id.btnSetImage);
        description = findViewById(R.id.txt_description);

    }

    public void data(){
        changeImage();
    }

    public void changeImage(){
    }

    public void uploadData(Users user) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
    }

    @Override
    public void onClick(View v) {

    }
}
