package com.develop.pets_care.view_user;
import android.Manifest;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.core.app.ActivityCompat;
import com.develop.pets_care.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class User_Activity_Login extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="EmailPassword" ;
    private Button btn_login;
    private Button btn_register;
    private EditText email;
    private EditText pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        setTitle("Inicio de sesion usuario");

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        email = findViewById(R.id.user_email);
        pass = findViewById(R.id.user_password);


        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        
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
                                Intent i = new Intent(this, User_Activity_Feed.class);
                                startActivity(i);
                                Toast.makeText(User_Activity_Login.this, "Authentication Successfully.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(User_Activity_Login.this, "Authentication failed.",
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
    public void onClick(View v) {
        if(btn_login==v){
            emailAndPass();
        }
        else if(btn_register==v){
            permits();
            Intent i = new Intent(this, User_Activity_Registration.class);
            startActivity(i);
        }

    }
}
