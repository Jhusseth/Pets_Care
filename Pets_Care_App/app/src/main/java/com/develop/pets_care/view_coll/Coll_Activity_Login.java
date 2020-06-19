package com.develop.pets_care.view_coll;

import android.Manifest;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.develop.pets_care.R;
import com.develop.pets_care.view_user.User_Activity_Feed;
import com.develop.pets_care.view_user.User_Activity_Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Coll_Activity_Login extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";
    private Button btn_login;
    private Button btn_register;
    private EditText email;
    private EditText pass;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_login);
        setTitle("Inicio de sesion colaborador");

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        email = findViewById(R.id.coll_email);
        pass = findViewById(R.id.coll_password);

        mAuth = FirebaseAuth.getInstance();

    }

    public void permits(){
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        },0);
    }

    public void emailAndPass(){
        if(!email.getText().toString().isEmpty()){
            if(!pass.getText().toString().isEmpty()){
                mAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString())
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                permits();
                                String[] push = email.getText().toString().split("@");
                                String[] push1 = push[1].split("\\.");
                                String pushId = push[0]+push1[0]+push1[1];
                                Intent i = new Intent(this, Coll_Activity_Feed.class);
                                i.putExtra("coll",pushId);
                                startActivity(i);
                                Toast.makeText(Coll_Activity_Login.this, "Authentication Successfully.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Coll_Activity_Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            else{
                Toast.makeText(this,"Debe ingresar una contraseña",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Debe ingresar un correo",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {

        if(btn_login==view){
            emailAndPass();
        }
        else if(btn_register==view){
            permits();
            Intent i = new Intent(this, Coll_Activity_Registration.class);
            startActivity(i);
        }

    }
}
